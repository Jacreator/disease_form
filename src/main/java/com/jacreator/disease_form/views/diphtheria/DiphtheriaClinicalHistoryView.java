package com.jacreator.disease_form.views.diphtheria;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class DiphtheriaClinicalHistoryView extends VerticalLayout{
// Form fields
    private RadioButtonGroup<String> fever;
    private DatePicker dateOfFeverOnset;
    private DatePicker dateOfVisitToHealthFacility;
    private RadioButtonGroup<String> neckSwelling;
    private RadioButtonGroup<String> pharyngitisTonsilitis;
    private RadioButtonGroup<String> presenceOfAdherentPseudoMembrane;
    private CheckboxGroup<String> locationOfAdherentPseudoMembrane;
    private RadioButtonGroup<String> laryngitis;
    private RadioButtonGroup<String> bleeding;
    private RadioButtonGroup<String> skinLeisions;
    private TextField others;
    private DatePicker dateOfOnset;
    private DatePicker dateHealthFacilityNotifiedLga;
    private DatePicker dateOfHospitalization;
    private RadioButtonGroup<String> antibioticsAdministered;
    private TextField nameAntibiotics;
    private DatePicker dateOfFirstDose;
    private RadioButtonGroup<String> antitoxinAdministered;
    private DatePicker dateOfAntitoxin;

    public DiphtheriaClinicalHistoryView() {
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
                new FormLayout.ResponsiveStep("600px", 2),
                new FormLayout.ResponsiveStep("900px", 3)
        );

        // Fever (≥38 °C)
        fever = new RadioButtonGroup<>("Fever (≥38 °C)");
        fever.setItems("yes", "no", "unknown");
        fever.setRequired(true);
        fever.setRequiredIndicatorVisible(true);

        // Date of fever onset
        dateOfFeverOnset = new DatePicker("Date of fever onset");
        dateOfFeverOnset.setMax(LocalDate.now());
        dateOfFeverOnset.setRequired(true);
        dateOfFeverOnset.setRequiredIndicatorVisible(true);

        // Date seen at the health facility
        dateOfVisitToHealthFacility = new DatePicker("Date seen at the health facility");
        dateOfVisitToHealthFacility.setMax(LocalDate.now());
        dateOfVisitToHealthFacility.setRequired(true);
        dateOfVisitToHealthFacility.setRequiredIndicatorVisible(true);

        // Neck swelling
        neckSwelling = new RadioButtonGroup<>("Neck swelling");
        neckSwelling.setItems("yes", "no", "unknown");
        neckSwelling.setRequired(true);
        neckSwelling.setRequiredIndicatorVisible(true);

        // Pharyngitis/Tonsilitis
        pharyngitisTonsilitis = new RadioButtonGroup<>("Pharyngitis/Tonsilitis");
        pharyngitisTonsilitis.setItems("yes", "no", "unknown");
        pharyngitisTonsilitis.setRequired(true);
        pharyngitisTonsilitis.setRequiredIndicatorVisible(true);

        // Presence of adherent pseudo-membrane
        presenceOfAdherentPseudoMembrane = new RadioButtonGroup<>("Presence of adherent pseudo-membrane?");
        presenceOfAdherentPseudoMembrane.setItems("yes", "no", "unknown");
        presenceOfAdherentPseudoMembrane.setRequired(true);
        presenceOfAdherentPseudoMembrane.setRequiredIndicatorVisible(true);

        // Location of adherent pseudo-membrane
        locationOfAdherentPseudoMembrane = new CheckboxGroup<>("Location of adherent pseudo-membrane?");
        locationOfAdherentPseudoMembrane.setItems("Throat", "Pharynx", "Larynx");
        locationOfAdherentPseudoMembrane.setRequired(true);

        // Laryngitis
        laryngitis = new RadioButtonGroup<>("Laryngitis");
        laryngitis.setItems("yes", "no", "unknown");
        laryngitis.setRequired(true);
        laryngitis.setRequiredIndicatorVisible(true);

        // Bleeding (from orifices)
        bleeding = new RadioButtonGroup<>("Bleeding (from orifices)");
        bleeding.setItems("yes", "no", "unknown");
        bleeding.setRequired(true);
        bleeding.setRequiredIndicatorVisible(true);

        // Skin leisions
        skinLeisions = new RadioButtonGroup<>("Skin leisions");
        skinLeisions.setItems("yes", "no", "unknown");
        skinLeisions.setRequired(true);
        skinLeisions.setRequiredIndicatorVisible(true);

        // Others (Specify)
        others = new TextField("Others (Specify)");
        others.setPlaceholder("Enter other symptoms");
        others.setRequired(true);
        others.setRequiredIndicatorVisible(true);

        // Date of symptom onset
        dateOfOnset = new DatePicker("Date of symptom onset");
        dateOfOnset.setMax(LocalDate.now());
        dateOfOnset.setRequired(true);
        dateOfOnset.setRequiredIndicatorVisible(true);

        // Date health facility notified LGA
        dateHealthFacilityNotifiedLga = new DatePicker("Date health facility notified LGA");
        dateHealthFacilityNotifiedLga.setMax(LocalDate.now());
        dateHealthFacilityNotifiedLga.setRequired(true);
        dateHealthFacilityNotifiedLga.setRequiredIndicatorVisible(true);

        // Date of hospitalization
        dateOfHospitalization = new DatePicker("Date of hospitalization");
        dateOfHospitalization.setMax(LocalDate.now());
        dateOfHospitalization.setRequired(true);
        dateOfHospitalization.setRequiredIndicatorVisible(true);

        // Antibiotics administered
        antibioticsAdministered = new RadioButtonGroup<>("Antibiotics administered");
        antibioticsAdministered.setItems("yes", "no", "unknown");
        antibioticsAdministered.setRequired(true);
        antibioticsAdministered.setRequiredIndicatorVisible(true);

        // Name of antibiotics
        nameAntibiotics = new TextField("Name of antibiotics");
        nameAntibiotics.setPlaceholder("Enter name of antibiotics");
        nameAntibiotics.setRequired(true);
        nameAntibiotics.setRequiredIndicatorVisible(true);

        // Date of first dose
        dateOfFirstDose = new DatePicker("Date of first dose");
        dateOfFirstDose.setMax(LocalDate.now());
        dateOfFirstDose.setRequired(true);
        dateOfFirstDose.setRequiredIndicatorVisible(true);

        // Antitoxin administered?
        antitoxinAdministered = new RadioButtonGroup<>("Antitoxin administered?");
        antitoxinAdministered.setItems("yes", "no", "unknown");
        antitoxinAdministered.setRequired(true);
        antitoxinAdministered.setRequiredIndicatorVisible(true);

        // Date of antitoxin
        dateOfAntitoxin = new DatePicker("Date of antitoxin");
        dateOfAntitoxin.setMax(LocalDate.now());
        dateOfAntitoxin.setRequired(true);
        dateOfAntitoxin.setRequiredIndicatorVisible(true);

        // Add all components to the form
        form.add(
                fever,
                dateOfFeverOnset,
                dateOfVisitToHealthFacility,
                neckSwelling,
                pharyngitisTonsilitis,
                presenceOfAdherentPseudoMembrane,
                locationOfAdherentPseudoMembrane,
                laryngitis,
                bleeding,
                skinLeisions,
                others,
                dateOfOnset,
                dateHealthFacilityNotifiedLga,
                dateOfHospitalization,
                antibioticsAdministered,
                nameAntibiotics,
                dateOfFirstDose,
                antitoxinAdministered,
                dateOfAntitoxin
        );

        return form;
    }
}
