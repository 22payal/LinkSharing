package linksharing

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

    def save(Topic topic, String seriousness)
    {

    }
}
