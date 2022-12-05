package controllers;

import models.Id;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
    private MessageController msgCtrl;
    private IdController idCtrl;

    public TransactionController(MessageController m, IdController j) {
        this.msgCtrl = m;
        this.idCtrl = j;
    }

    public List<Id> getIds() {
        return idCtrl.getIds(); //change this
    }
    public String postId(String idtoRegister, String githubName) {
        Id tid = new Id(idtoRegister, githubName);
        tid = idCtrl.postId(tid);
        return ("Id registered.");
    }

    public String makecall(String s, String get, String s1)  {
        StringBuilder sb = new StringBuilder();
        if (s.equalsIgnoreCase("Ids") && get.equalsIgnoreCase("GET")) {
            for (Id j: getIds()) {
                sb.append(j + "\n");
            }
            return sb.toString();
        }
        else if (s.equalsIgnoreCase("Ids")) {

            return postId(get, s1);  //fix this
        }

        return "Not working here"; //todo: fill this in
    }

}
