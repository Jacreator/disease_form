package com.jacreator.disease_form.views.buruliUlcer;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class BuruliUlcerContactTracingView extends VerticalLayout {
public BuruliUlcerContactTracingView() {
        setWidthFull();
        
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Complete Address
        TextField clientAddress = new TextField("Complete Address");
        clientAddress.setPlaceholder("Enter Address");
        clientAddress.setRequired(true);

        // Add field to the form
        form.add(clientAddress);

        return form;
    }
}
