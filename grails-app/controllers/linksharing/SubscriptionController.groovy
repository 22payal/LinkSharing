package linksharing

import enumeration.Seriousness

class SubscriptionController {

    def index() { }



    def subscriptionSave(Integer id)
    {
       Topic newtopic=  Topic.load(id)
         Subscription subscription = new Subscription(user:session.user,topic:newtopic ,seriousness: "Serious")
          if (subscription.save())
          {
              render("Subscription successfully saved")
          }
        else
          {
              render("Error found while saving Subscription")
          }
    }

    def subscriptionUpdate(Integer id, String seriousness)
    {
         Subscription subscription =Subscription.load(id)

        if ((subscription)&&(Seriousness.convertSeriousness(seriousness)))
        {
            subscription.save()

            if ( subscription.save())
            {
                render("Updated Subscription successfully saved")
            }
            else
            {
                render("Error while saving Subscription ")
            }
        }

        else
        {
            render("error while updating subscription")
        }
    }

    def subscriptionDelete(Integer id) {
        Topic topic = Topic.load(id)
        if (topic.delete()) {
            flash.message = "success"

        } else {
            flash.error = "error"

        }


    }

}
