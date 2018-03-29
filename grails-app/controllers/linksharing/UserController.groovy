package linksharing

import enumeration.Visibility

class UserController {

    def index() {

      //  render("user dashboard")
        render(session.user.userName)

    }

    def show(Integer id)
    {
        if (Topic.findAllById(id).size()==0) {
            flash.error = "NO SUCH TOPIC"
            redirect(controller: 'login', action: 'index')

        }
        else {
            if (Topic.findByVisibility(Visibility.PUBLIC)) {
                render("SUCCESS")

            }

    }

