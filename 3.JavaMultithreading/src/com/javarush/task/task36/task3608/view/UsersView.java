package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class UsersView implements View {
    private Controller controller;
    @Override
    public void refresh(ModelData modelData) {
        System.out.printf("All%s users:%n",modelData.isDisplayDeletedUserList()?" deleted":"");
        modelData.getUsers().stream().map(u->"\t"+u).forEach(System.out::println);
        System.out.println("===================================================");

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers(){                controller.onShowAllUsers(); }
    public void fireEventShowDeletedUsers() {           controller.onShowAllDeletedUsers(); }
    public void fireEventOpenUserEditForm(long id) {    controller.onOpenUserEditForm(id); }

}
