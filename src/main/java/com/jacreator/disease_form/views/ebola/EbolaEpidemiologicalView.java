package com.jacreator.disease_form.views.ebola;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class EbolaEpidemiologicalView extends VerticalLayout{
// Form fields
    private RadioButtonGroup<String> patientTravelIllness;
    private TextField travelAddress;
    private RadioButtonGroup<String> caseHospitalized;
    private DatePicker dateHospitalVisit;
    private TextField addressHospitalVisit;
    private RadioButtonGroup<String> locationTraditionalHealer;
    private TextField nameTraditionalHealer;
    private TextField addressTraditionalHealer;
    private RadioButtonGroup<String> traditionalMedicine;
    private TextField traditionalMedicineType;
    private RadioButtonGroup<String> visitFuneralCeremonies;
    private RadioButtonGroup<String> contactSuspectConfirmed;
    private TextField epidCase;
    private RadioButtonGroup<String> animalContact;
    private TextField kindAnimal;
    private RadioButtonGroup<String> caseAdmission;
    private TextField nameOfHospital;
    private DatePicker dateOfAdmission;
    private DatePicker dateDischarge;
    private RadioButtonGroup<String> patientOutcomeDischarge;

    // State for dynamic fields
    private Map<String, Object> formValues = new HashMap<>();

    public EbolaEpidemiologicalView() {
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

        // 1. Did the patient travel during or after illness?
        patientTravelIllness = new RadioButtonGroup<>("Did the patient travel during or after illness?");
        patientTravelIllness.setItems("yes", "no", "unknown");
        patientTravelIllness.setRequired(true);
        patientTravelIllness.setRequiredIndicatorVisible(true);

        travelAddress = new TextField("Travel Address of patient during or after illness");
        travelAddress.setPlaceholder("Enter address visited");
        travelAddress.setVisible(false);

        patientTravelIllness.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            travelAddress.setVisible(show);
            formValues.put("patientTravelIllness", e.getValue());
        });

        // 2. Patient hospitalized or visit anyone in the hospital before illness?
        caseHospitalized = new RadioButtonGroup<>("Patient hospitalized or visit anyone in the hospital before illness?");
        caseHospitalized.setItems("yes", "no", "unknown");
        caseHospitalized.setRequired(true);
        caseHospitalized.setRequiredIndicatorVisible(true);

        dateHospitalVisit = new DatePicker("Date of visit or hospitalization?");
        dateHospitalVisit.setMax(LocalDate.now());
        dateHospitalVisit.setVisible(false);

        addressHospitalVisit = new TextField("Address of hospital visited or hospitalized in?");
        addressHospitalVisit.setPlaceholder("Enter hospital Address");
        addressHospitalVisit.setVisible(false);

        caseHospitalized.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            dateHospitalVisit.setVisible(show);
            addressHospitalVisit.setVisible(show);
            // Traditional healer fields are also shown if hospitalized
            nameTraditionalHealer.setVisible(show);
            addressTraditionalHealer.setVisible(show);
            traditionalMedicine.setVisible(show);
            traditionalMedicineType.setVisible(show);
            formValues.put("caseHospitalized", e.getValue());
        });

        // 3. Did case visit a traditional healer in 3 weeks before onset
        locationTraditionalHealer = new RadioButtonGroup<>("Did case visit a traditional healer in 3 weeks before onset");
        locationTraditionalHealer.setItems("yes", "no", "unknown");
        locationTraditionalHealer.setRequiredIndicatorVisible(true);

        nameTraditionalHealer = new TextField("Name of traditional healer");
        nameTraditionalHealer.setPlaceholder("Enter name of healer");
        nameTraditionalHealer.setVisible(false);

        addressTraditionalHealer = new TextField("Address of traditional healer");
        addressTraditionalHealer.setPlaceholder("Enter address of healer");
        addressTraditionalHealer.setVisible(false);

        traditionalMedicine = new RadioButtonGroup<>("Did the patient receive traditional medicine?");
        traditionalMedicine.setItems("yes", "no", "unknown");
        traditionalMedicine.setVisible(false);

        traditionalMedicineType = new TextField("Traditional Medicine type");
        traditionalMedicineType.setPlaceholder("Enter Medicine Type");
        traditionalMedicineType.setVisible(false);

        // 4. Did case attend funeral ceremonies anytime in the 3 weeks before illness?
        visitFuneralCeremonies = new RadioButtonGroup<>("Did case attend funeral ceremonies anytime in the 3 weeks before illness?");
        visitFuneralCeremonies.setItems("yes", "no", "unknown");

        // 5. Did the patient have contact with a known suspect / confirmed case anytime in the three weeks before becoming ill?
        contactSuspectConfirmed = new RadioButtonGroup<>("Did the patient have contact with a known suspect / confirmed case anytime in the three weeks before becoming ill?");
        contactSuspectConfirmed.setItems("yes", "no", "unknown");

        epidCase = new TextField("Epid number of the case");
        epidCase.setPlaceholder("Enter Epid Number of case");
        epidCase.setVisible(false);

        contactSuspectConfirmed.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            epidCase.setVisible(show);
            formValues.put("contactSuspectConfirmed", e.getValue());
        });

        // 6. Did the patient have contact with a wild animal (non-human primate or others)?
        animalContact = new RadioButtonGroup<>("Did the patient have contact with a wild animal (non-human primate or others)?");
        animalContact.setItems("yes", "no", "unknown");

        kindAnimal = new TextField("Kind of animal");
        kindAnimal.setPlaceholder("Enter Animal Name");
        kindAnimal.setVisible(false);

        animalContact.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            kindAnimal.setVisible(show);
            formValues.put("animalContact", e.getValue());
        });

        // 7. Was the patient admitted in the isolation ward?
        caseAdmission = new RadioButtonGroup<>("Was the patient admitted in the isolation ward?");
        caseAdmission.setItems("yes", "no", "unknown");

        nameOfHospital = new TextField("Name of Hospital");
        nameOfHospital.setPlaceholder("Enter Hospital Name");
        nameOfHospital.setVisible(false);

        dateOfAdmission = new DatePicker("Date of admission?");
        dateOfAdmission.setMax(LocalDate.now());
        dateOfAdmission.setVisible(false);

        dateDischarge = new DatePicker("Date of discharge");
        dateDischarge.setMax(LocalDate.now());
        dateDischarge.setVisible(false);

        patientOutcomeDischarge = new RadioButtonGroup<>("Patient outcome at discharge");
        patientOutcomeDischarge.setItems("Alive", "Dead");
        patientOutcomeDischarge.setVisible(false);

        caseAdmission.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            nameOfHospital.setVisible(show);
            dateOfAdmission.setVisible(show);
            dateDischarge.setVisible(show);
            patientOutcomeDischarge.setVisible(show);
            formValues.put("caseAdmission", e.getValue());
        });

        // Add all components to the form
        form.add(
            patientTravelIllness, travelAddress,
            caseHospitalized, dateHospitalVisit, addressHospitalVisit,
            locationTraditionalHealer, nameTraditionalHealer, addressTraditionalHealer, traditionalMedicine, traditionalMedicineType,
            visitFuneralCeremonies,
            contactSuspectConfirmed, epidCase,
            animalContact, kindAnimal,
            caseAdmission, nameOfHospital, dateOfAdmission, dateDischarge, patientOutcomeDischarge
        );

        return form;
    }
}
