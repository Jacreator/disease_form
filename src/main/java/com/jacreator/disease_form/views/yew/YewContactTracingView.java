package com.jacreator.disease_form.views.yew;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class YewContactTracingView extends VerticalLayout {
public YewContactTracingView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Complete Address
        TextField clientAddress = new TextField("Complete Address");
        clientAddress.setPlaceholder("Enter Address");

        // Add field to the form
        form.add(clientAddress);

        return form;
    }
}
