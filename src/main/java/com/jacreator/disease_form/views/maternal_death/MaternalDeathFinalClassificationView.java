package com.jacreator.disease_form.views.maternal_death;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class MaternalDeathFinalClassificationView extends VerticalLayout {
private TextField clientAddress;

    public MaternalDeathFinalClassificationView() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);

        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();
        form.setWidthFull();
        form.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("600px", 2)
        );

        clientAddress = new TextField("Complete Address");
        clientAddress.setPlaceholder("Enter Address");
        clientAddress.setRequired(true);
        clientAddress.setRequiredIndicatorVisible(true);

        form.add(clientAddress);

        return form;
    }
}
