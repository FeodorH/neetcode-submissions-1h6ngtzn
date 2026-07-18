data class User(
    val id: Int,
    val follows: MutableSet<Int>,
    val tweets: MutableSet<Int>
)

data class Tweet(
    val id: Int,
    val userId: Int
)

class Twitter {
    val tweets = mutableListOf<Tweet>()
    val users: MutableMap<Int, User> = mutableMapOf()

    fun postTweet(userId: Int, tweetId: Int) {
        if (users.containsKey(userId)) {
            users[userId]!!.tweets.add(tweetId)
        } else {
            users[userId] = User(
                id = userId,
                follows = mutableSetOf(userId),
                tweets = mutableSetOf(tweetId)
            )
        }
        tweets.add(Tweet(
            id = tweetId,
            userId = userId,
        ))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        if (users.containsKey(userId)) {
            val result = mutableListOf<Int>()
            for(i in tweets.size - 1 downTo 0) {
                if(users[userId]!!.follows.contains(tweets[i].userId)) {
                    result.add(tweets[i].id)
                    if(result.size >=10){
                        break
                    }
                }
            }
            return result
        }
        return emptyList()
    }

    fun follow(followerId: Int, followeeId: Int) {
        if(followerId==followeeId)return
        val follower = users.getOrPut(followerId) { User(followerId,mutableSetOf(followerId),mutableSetOf()) }
        val followee = users.getOrPut(followeeId) { User((followeeId), mutableSetOf(followerId), mutableSetOf()) }
        users[followerId]!!.follows.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        if (users.containsKey(followerId) && users.containsKey(followeeId)) {
            if(followerId==followeeId)return
            users[followerId]!!.follows.remove(followeeId)
        }
    }
}