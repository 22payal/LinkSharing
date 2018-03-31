package linksharing

import co.ResourceSearchCo
import vo.RatingInfoVo
import vo.ResourceVo


abstract class Resource {
    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated
    RatingInfoVo ratingInfo

    void setRatingInfo()
    {
        this.ratingInfoVo=getResourceRating()
    }

    static hasMany = [resourceRating:ResourceRating,readingItem:ReadingItem]

    static belongsTo = [createdBy:User,topic:Topic]

    static constraints = {
        description(type:'text')
    }
  static transients = ['ratingInfo']
    static namedQueries = {
        search{
            ResourceSearchCo resourceSearchCo->
                if (resourceSearchCo.topicId)
                    eq('topic.id',resourceSearchCo.topicId)

                if (resourceSearchCo.visibility)
                    eq('topic.visibility', resourceSearchCo.visibility)

        }
           }


    Integer totalScore()
    {
       Integer totalScore = ResourceRating.createCriteria().get {

           projections{
               sum('score')
           }

           eq('resource',this)
       }

        return totalScore
    }

    Double averageScore()
    {
        Double averageScore = ResourceRating.createCriteria().get(){
            projections{
                avg('score')
            }

            eq('resource',this)
        }
        return  averageScore
    }

    Integer totalVotes()
    {
        Integer totalVotes = ResourceRating.createCriteria().count()
                {
                    eq('resource',this)
                }
        return totalVotes
    }


    RatingInfoVo getResourceRatingInformation() {
                RatingInfoVo ratingInfoVO = new RatingInfoVo()
                ratingInfoVO.totalVotes = totalVotes()
                ratingInfoVO.totalScore = totalScore()
                ratingInfoVO.averageScore = averageScore()
                return ratingInfoVO

    }

    static List<ResourceVo> getTopPost(){
              List<ResourceVo> topPosts = ResourceRating.createCriteria().list(){
                        projections{
                                createAlias('resource', 'r')
                                groupProperty('r.id')
                                property('r.createdBy')
                                property('r.topic.name')
                                count('r.id', 'count')
                            }
                        order('count', 'desc')
                        maxResults(5)
                   }

        return topPosts
           }
}


