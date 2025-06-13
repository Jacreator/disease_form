package com.jacreator.disease_form.views.dengue;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class DengueEpidemiologicalView extends VerticalLayout {
private RadioButtonGroup<String> vaccinationStatus;
    private RadioButtonGroup<String> numberOfVaccineDose;
    private DatePicker dateOfVaccination;
    private RadioButtonGroup<String> sourceVaccinationHistory;
    private TextField travelHistory;
    private RadioButtonGroup<String> locationHistoryOfFever;
    private RadioButtonGroup<String> patientPresentCondition;

    public DengueEpidemiologicalView() {
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

        vaccinationStatus = new RadioButtonGroup<>("Vaccination Status");
        vaccinationStatus.setItems("vaccinated", "notVaccinated", "unknown");
        vaccinationStatus.setRequired(true);
        vaccinationStatus.setRequiredIndicatorVisible(true);

        numberOfVaccineDose = new RadioButtonGroup<>("Number of vaccine doses");
        numberOfVaccineDose.setItems("1", "2+");
        numberOfVaccineDose.setRequired(true);
        numberOfVaccineDose.setRequiredIndicatorVisible(true);
        numberOfVaccineDose.setVisible(false);

        dateOfVaccination = new DatePicker("Date of Vaccination");
        dateOfVaccination.setRequired(true);
        dateOfVaccination.setRequiredIndicatorVisible(true);
        dateOfVaccination.setMax(LocalDate.now());
        dateOfVaccination.setVisible(false);

        sourceVaccinationHistory = new RadioButtonGroup<>("Source of vaccination history");
        sourceVaccinationHistory.setItems("card", "verbal");
        sourceVaccinationHistory.setRequired(true);
        sourceVaccinationHistory.setRequiredIndicatorVisible(true);
        sourceVaccinationHistory.setVisible(false);

        // Show/hide vaccine fields based on vaccination status
        vaccinationStatus.addValueChangeListener(e -> {
            boolean showVaccineFields = "vaccinated".equals(e.getValue());
            numberOfVaccineDose.setVisible(showVaccineFields);
            numberOfVaccineDose.setRequired(showVaccineFields);
            numberOfVaccineDose.setRequiredIndicatorVisible(showVaccineFields);

            dateOfVaccination.setVisible(showVaccineFields);
            dateOfVaccination.setRequired(showVaccineFields);
            dateOfVaccination.setRequiredIndicatorVisible(showVaccineFields);

            sourceVaccinationHistory.setVisible(showVaccineFields);
            sourceVaccinationHistory.setRequired(showVaccineFields);
            sourceVaccinationHistory.setRequiredIndicatorVisible(showVaccineFields);

            if (!showVaccineFields) {
                numberOfVaccineDose.clear();
                dateOfVaccination.clear();
                sourceVaccinationHistory.clear();
            }
        });

        travelHistory = new TextField("List names of villages, towns or LGAs that patient visited in the last 3 weeks");
        travelHistory.setPlaceholder("Enter travel history");

        locationHistoryOfFever = new RadioButtonGroup<>("Have cases of fever and jaundice been seen or reported in places visited by the patient in the last 2 weeks before onset of symptoms?");
        locationHistoryOfFever.setItems("yes", "no", "unknown");
        locationHistoryOfFever.setRequired(true);
        locationHistoryOfFever.setRequiredIndicatorVisible(true);

        patientPresentCondition = new RadioButtonGroup<>("Patient Present Condition");
        patientPresentCondition.setItems("Alive", "Dead", "Unknown");
        patientPresentCondition.setRequired(true);
        patientPresentCondition.setRequiredIndicatorVisible(true);

        form.add(
            vaccinationStatus,
            numberOfVaccineDose,
            dateOfVaccination,
            sourceVaccinationHistory,
            travelHistory,
            locationHistoryOfFever,
            patientPresentCondition
        );

        return form;
    }
}
