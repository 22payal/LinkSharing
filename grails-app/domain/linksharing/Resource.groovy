package linksharing


abstract class Resource {
    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated

    static hasMany = [resourceRating:ResourceRating,readingItem:ReadingItem]

    static belongsTo = [createdBy:User,topic:Topic]

    static constraints = {
        description(type:'text')
    }
}

