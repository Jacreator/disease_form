package com.jacreator.disease_form.views.maternal_death;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class MaternalDeathLaboratoryInformationView extends VerticalLayout {
private TextField clientAddress;

    public MaternalDeathLaboratoryInformationView() {
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

        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));
        form.add(clientAddress);

        return form;
    }
}
