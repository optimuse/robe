package io.robe.admin.view;

import io.dropwizard.views.View;
import io.robe.common.dto.BasicPair;


public class ChangePasswordView extends View {

    private BasicPair ticket;
    private BasicPair mail;
    private BasicPair url;

    public ChangePasswordView(String tickedOid, String mail, String url) {
        super("ChangePassword.ftl");
        this.ticket = new BasicPair("tickedOid", tickedOid);
        this.mail = new BasicPair("mail", mail);
        this.url = new BasicPair("url", url);
    }

    public BasicPair getUrl() {
        return url;
    }

    public BasicPair getTicket() {
        return ticket;
    }

    public BasicPair getMail() {
        return mail;
    }
}
