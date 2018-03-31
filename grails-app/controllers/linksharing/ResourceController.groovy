package linksharing

import co.ResourceSearchCo
import enumeration.Visibility
import vo.RatingInfoVo

class ResourceController {

    def index() { }

    def resourceDelete(Integer id)
    {
        Resource resource=Resource.load(id)

        if(!resource)
        {
           throw new Exception( "exception of object not found")
        }
    }

    def search(ResourceSearchCo resourceSearchCo) {
              if (resourceSearchCo.q) {
                        resourceSearchCo.visibility=Visibility.PUBLIC
                    }
           }

        def show(Integer resourceId){
                Resource resource = Resource.findById(resourceId)
                RatingInfoVo ratingInfoVO = resource.getResourceRatingInformation()
                render("TOTAL VOTES- $ratingInfoVO.totalVotes + TOTAL SCORE- $ratingInfoVO.totalScore + AVERAGE SCORE- $ratingInfoVO.averageScore")
            }


}
