package com.jacreator.disease_form.views.rubella;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class RubellaContactTracingView extends VerticalLayout{
public RubellaContactTracingView() {
        setWidthFull();
        
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Complete Address
        TextField clientAddress = new TextField("Complete Address");
        clientAddress.setPlaceholder("Enter Address");

        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2)
        );
        form.add(clientAddress);

        return form;
    }
}
