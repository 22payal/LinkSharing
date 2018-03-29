package linksharing

import enumeration.Visibility

class UserController {

    def index() {

      //  render("user dashboard")
        render(session.user.userName)

    }

}

