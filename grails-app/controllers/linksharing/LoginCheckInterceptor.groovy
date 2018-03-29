package linksharing


class LoginCheckInterceptor {
    LoginCheckInterceptor()
    {
        matchAll().excludes(controller: 'login',action:'loginHandler')
    }

}
