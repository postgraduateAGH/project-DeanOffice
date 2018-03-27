package com.mwo.group2;

import java.util.List;

public abstract class User {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    String name;
    String surname;
    List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }
    
    public Message readMessage(int index) {
        return messages.get(index);
    }
    
    abstract void writeMessage();

    abstract boolean sendMessage(int index);
}
