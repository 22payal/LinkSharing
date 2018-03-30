package linksharing


import enumeration.Seriousness


class Subscription {
    Topic topic
    User user
    Date dateCreated
    Seriousness seriousness


    static belongsTo = [topic:Topic,user:User]

    static constraints = {
        user (nullable: false )
        topic(nullable: false , unique:'user')
        seriousness(nullable:false)

    }

    static mapping = {
        seriousness enumType: 'SERIOUS'
    }

    Subscription(Topic topic, User user, Seriousness seriousness) {
        this.topic = topic
        this.user = user
        this.seriousness = seriousness
    }
}
