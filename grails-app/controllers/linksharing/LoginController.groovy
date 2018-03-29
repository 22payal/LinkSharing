package linksharing


class LoginController {

    def index() {
        if(session.user)
            forward(controller: 'user',action:'index')
        else
            render( 'failure')

    }
    def logout() {

    }

    def loginHandler()
    {

    }
}