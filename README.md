# SocialPlatformBackend

Endpoints:  
/api/posts - all posts  
/api/posts/last - last 20 posts  
/api/posts/p/1 - paginated posts  
/api/top - top 10 posts by views  
/api/author - last 10 posts by author  
/api/post/1 - post by id  
/api/generate - generate some dummy posts  
/api/post/new - create new post with POST request:

        method: "POST",
        body: JSON.stringify({
          author: "author",
          content: "content"
        }),
        headers: {
            'Content-Type': 'application/json'
        }
