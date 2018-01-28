package dke.pr.g3.utils;

import dke.pr.g3.db.DBConnection;
import dke.pr.g3.entities.User;
import dke.pr.g3.model.Role;
import dke.pr.g3.model.Status;
import dke.pr.g3.model.Type;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private List<Role> selectedRoles = new ArrayList<>();
    private List<User> selectedUsers = new ArrayList<>();

    public String sendEditMessage(String content, User user, String type) {
        switch (type) {
            case "parameter":
                DBConnection.newMessage(user, "ChangeParameter", "Please change the following parameter: " + content, Type.A, Status.U, this.selectedUsers, this.messageTo(Role.RA));
                break;
            case "ctx":
                DBConnection.newMessage(user, "ChangeContext", "Please change the following context: " + content, Type.A, Status.U, this.selectedUsers, this.messageTo(Role.RA));
                break;
            default:
                this.returnErrorFlashMessage();
                break;
        }

        return "messages?faces-redirect=true";
    }

    public void returnErrorFlashMessage() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = facesContext.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        flash.setRedirect(true);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Unknown Content", "Unknown content: Please check out sendEditMessage Method from Utils"));
    }


    //
    //  Private Methods ------------------------------------------------------
    //

    private List<Role> messageTo(Role role) {
        if (this.selectedRoles.contains(role)) {
            this.selectedRoles.remove(role);
        } else {
            this.selectedRoles.add(role);
        }

        return this.selectedRoles;
    }
}
