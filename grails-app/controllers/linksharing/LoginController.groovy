package linksharing


class LoginController {

    def index() {
        if (session.user)
            forward(controller: 'User', action: 'index')
        else
            render('failure')

    }

    def logout() {
        session.invalidate()
        redirect(controller: 'Login',action: 'index')

    }

    def loginHandler(String userName, String password) {
        User user = User.findByUserNameAndPassword(userName, password)
        if (user != null) {
            if (user.active) {
                session.user = user
                redirect(action: 'index')

            }
            else {
                flash.error = "Your account is not active"

            }

        }

        else
        {
            flash.error="User not found"
        }
    }
}
