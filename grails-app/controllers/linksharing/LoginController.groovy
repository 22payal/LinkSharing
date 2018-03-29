package linksharing


class LoginController {

    def index() {
        if(session.user)
            forward(controller: 'user',action:'index')
        else
            render( 'failure')

    }
    def logout() {
        session.invalidate()
        redirect(action:'login/index')

 }

    def loginHandler(String userName,String password)
    {

    }
}