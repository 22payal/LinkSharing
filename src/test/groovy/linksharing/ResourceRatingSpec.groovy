package linksharing

import enumeration.Visibility
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ResourceRatingSpec extends Specification implements DomainUnitTest<ResourceRating> {

    def setup() {
    }

    def cleanup() {
    }

//    void "test something"() {
//        expect:"fix me"
//            true == false
//    }


    def "user should not have null "(){
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = "payal123"
        User user = new User(
                email: email,
                userName: "payalNigam",
                password: password,
                firstName: "Payal",
                lastName: "Nigam",
                admin: false,
                active: true
        )
        user.save()

        Topic topic = new Topic()
        topic.createdBy = user
        topic.topicName = "first topic"
        topic.visibility = Visibility.PUBLIC
        topic.save()

        Resource resource1=new LinkResource()

        resource1.url= "www.google.com"

        resource1.save()

        ResourceRating resourceRating1=new ResourceRating()
        resourceRating1.score=2
        resourceRating1.createdBy=user
        resourceRating1.resource=resource1

        ResourceRating resourceRating2=new ResourceRating()
        resourceRating2.score=2
        resourceRating2.createdBy=null
        resourceRating2.resource=resource1


        when:

        resourceRating1.save()

        then:
        resourceRating1.count()==1

        when:
        resourceRating2.save()


        then:
       // resourceRating2.errors.getFieldErrorCount('user')==1
        resourceRating2.errors.hasErrors()==true
    }

    def "resource should not be null "(){
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = 'payal123'
        User user = new User(
                email: email,
                userName:"payal123",
                password:password,
                firstName: "Payal",
                lastName: "Nigam",
                admin:false,
                active:true
        )
        user.save()
        Topic topic = new Topic(name:"grails_domain",visibility: Visibility.PUBLIC,createdBy: user)
        topic.save()
        Resource resource=new LinkResource(url: "www.google.com",description: "abhabhab",user: user,topic: topic)
        resource.save()
        ResourceRating resourceRating=new ResourceRating(score:2,user: user,resource:null)

        when:
        resourceRating.save()

        then:
        resourceRating.errors.hasErrors()==true
    }

    def "score should not be null "(){
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = 'payal123'
        User user = new User(
                email: email,
                userName:"payal",
                password:password,
                firstName: "Payal",
                lastName: "Nigam",
                admin:false,
                active:true
        )
        user.save()
        Topic topic = new Topic(name:"grails_domain",visibility: Visibility.PUBLIC,createdBy: user)
        topic.save()
        Resource resource=new LinkResource(url:"www.yahoo.com",description: "abhabhab",user: user,topic: topic)
        resource.save()
        ResourceRating resourceRating=new ResourceRating(score:null,user: user,resource:resource)

        when:
        resourceRating.save()

        then:
        resourceRating.errors.getFieldErrorCount('score')==1
        resourceRating.errors.hasErrors()==true

    }

    def "minimum and maximum score of rating should be 1 and 5 respectively"(){
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = 'payal123'
        User user = new User(
                email: email,
                userName:"payal",
                password:password,
                firstName: "Payal",
                lastName: "Nigam",
                admin:false,
                active:true
        )
        user.save()
        Topic topic = new Topic(name:"grails_domain",visibility: Visibility.PUBLIC,createdBy: user)
        topic.save()
        Resource resource=new LinkResource(url:"www.yahoo.com",description: "abhabhab",user: user,topic: topic)
        resource.save()
        ResourceRating resourceRating1=new ResourceRating(score: 1,user: user,resource: resource)
        ResourceRating resourceRating2=new ResourceRating(score: 5,user: user,resource: resource)

        ResourceRating resourceRating3=new ResourceRating(score:0,user: user,resource: resource)
        ResourceRating resourceRating4=new ResourceRating(score:6,user: user,resource: resource)

        when:
        resourceRating1.save()

        then:
        ResourceRating.count==1


        when:
       resourceRating1.save()
        then:
        ResourceRating.count==1


        when:
        resourceRating3.save()
        then:
        resourceRating2.errors.getFieldErrorCount('score')==1
        resourceRating2.errors.hasErrors()==true


        when:
        resourceRating4.save()




        then:
        resourceRating4.errors.getFieldErrorCount('score')==1
        resourceRating4.errors.hasErrors()==true
    }

    def "Resource rating can be given by a user only one time for a resource "(){
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = 'payal123'
        User user = new User(
                email: email,
                userName:"payal",
                password:password,
                firstName: "Payal",
                lastName: "Nigam",
                admin:false,
                active:true
        )
        user.save()
        Topic topic = new Topic(name:"grails_domain",visibility: Visibility.PUBLIC,createdBy: user)
       topic.save()
        Resource resource=new LinkResource(url:"www.yahoo.com",description: "abhabhab",user: user,topic: topic)
        resource.save()
        ResourceRating resourceRating1=new ResourceRating(score:2,user: user,resource:resource)
        ResourceRating resourceRating2=new ResourceRating(score:3,user:user,resource: resource)

        when:
        resourceRating1.save()
        then:
        resourceRating1.count()==1

        when:
        resource.save()
        then:
        resourceRating2.errors.hasErrors()==true

    }
}
