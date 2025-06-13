package com.jacreator.disease_form.views.maternal_death;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class MaternalDeathEpidemiologicalView extends VerticalLayout {
private TextField clientAddress;
    private ComboBox<String> facilityType;

    private static final List<String> facilityData = Arrays.asList(
            "Federal Medical Center", "Jabi Clinic"
    );

    public MaternalDeathEpidemiologicalView() {
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

        facilityType = new ComboBox<>("Type");
        facilityType.setPlaceholder("Select Facility Type");
        facilityType.setItems(facilityData);
        facilityType.setRequired(true);
        facilityType.setRequiredIndicatorVisible(true);

        form.add(clientAddress, facilityType);

        return form;
    }
}
