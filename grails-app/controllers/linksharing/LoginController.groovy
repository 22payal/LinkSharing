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

    def register() {
        User admin = new User(
                firstName:"Payal",
                lastName:"Nigam",
                userName:"payal.nigam",
                password:"payal123",
                email: "payal.nigam@tothenew.com",
                admin:true,
                active: true)

        if(admin.save()){
            flash.message="Admin Saved Successfully"
        }
        else {
            flash.error="error"
        }


        User normal = new User(
                firstName:"test user",
                lastName:  "first",
                userName:  "user.first",
                password:  "first123",
                email:  "test.first@tothenew.com",
                admin:false,
                active: true)


        if(normal.save()){
            flash.message="Admin Saved Successfully"
        }
        else {
            flash.error="error"
        }

        redirect(action: "index")

    }
}
