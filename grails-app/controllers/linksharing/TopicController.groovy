package linksharing

import enumeration.Visibility

class TopicController {

    def index() { }

    def topicShow()
    {
        Topic topic=Topic.read()
    }

    def topicDelete(Integer id)
    {
        Topic topic=Topic.load(id)
    }

   def topicSave() { }

    def save(Topic topic, String visibility)
    {
      println( Visibility.convertIntoEnum(visibility))
    }
}
