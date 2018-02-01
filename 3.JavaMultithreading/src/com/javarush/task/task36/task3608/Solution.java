package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model             = new MainModel();
        UsersView usersView     = new UsersView();
        Controller controller   = new Controller();
        EditUserView editUserView = new EditUserView();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);
        editUserView.setController(controller);


        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("IvanovEdit", 123L, 5);
        usersView.fireEventShowDeletedUsers();


//        fireEventShowAllUsers()
//        fireEventOpenUserEditForm(126L)
//        fireEventUserDeleted(124L)
//        fireEventShowDeletedUsers().


    }
}