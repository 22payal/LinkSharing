package linksharing

class ResourceController {

    def index() { }

    def resourceDelete(Integer id)
    {
        Resource resource=Resource.load(id)

        if(!resource)
        {
            render("exception of object not found")
        }
    }


}
