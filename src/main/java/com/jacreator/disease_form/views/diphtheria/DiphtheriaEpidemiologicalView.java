package com.jacreator.disease_form.views.diphtheria;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class DiphtheriaEpidemiologicalView extends VerticalLayout{
// Form fields
    private RadioButtonGroup<String> vaccinationStatus;
    private RadioButtonGroup<String> numberOfDiphtheriaContainingVaccine;
    private DatePicker dateOfLastVaccination;
    private RadioButtonGroup<String> sourceOfVaccinationHistory;
    private RadioButtonGroup<String> notVaccinatedReason;
    private TextField otherReasonNoVaccine;

    private RadioButtonGroup<String> didThePatientTravelDuringOrAfterIllness;
    private TextField clientAddress;

    private RadioButtonGroup<String> patientHospitalizedOrVisitAnyoneInTheHospitalBeforeIllness;
    private RadioButtonGroup<String> hospitalizationStatus;
    private DatePicker dateHospitalVisit;
    private TextField nameOfHospital;
    private TextField addressHospitalVisit;

    private RadioButtonGroup<String> wasThePatientAdmittedInTheIsolationWard;
    private DatePicker dateOfAdmissionPatientInIsolationWard;
    private DatePicker dateOfDischargePatientInIsolationWard;

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

    private RadioButtonGroup<String> wasThePatientAdmittedInTheIsolationWard2;
    private TextField nameOfHospitalPatientAdmittedInIsolation;
    private DatePicker dateOfAdmission;
    private DatePicker dateOfDischarge;
    private RadioButtonGroup<String> outcome;
    private DatePicker dateOfPatientDeath;

    public DiphtheriaEpidemiologicalView() {
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

        // Vaccination status
        vaccinationStatus = new RadioButtonGroup<>("Vaccination status");
        vaccinationStatus.setItems("vaccinated", "notVaccinated", "unknown");
        vaccinationStatus.setRequired(true);
        vaccinationStatus.setRequiredIndicatorVisible(true);

        numberOfDiphtheriaContainingVaccine = new RadioButtonGroup<>("Number of diphtheria containing vaccine dose received");
        numberOfDiphtheriaContainingVaccine.setItems("1", "2", "3", "4+");
        numberOfDiphtheriaContainingVaccine.setVisible(false);

        dateOfLastVaccination = new DatePicker("Date of last vaccination");
        dateOfLastVaccination.setMax(LocalDate.now());
        dateOfLastVaccination.setVisible(false);

        sourceOfVaccinationHistory = new RadioButtonGroup<>("Source of vaccination history");
        sourceOfVaccinationHistory.setItems("card", "verbal");
        sourceOfVaccinationHistory.setVisible(false);

        notVaccinatedReason = new RadioButtonGroup<>("If not vaccinated, indicate reason");
        notVaccinatedReason.setItems("religious exemption", "medical contraindication", "under age", "parental refusal", "unknown", "others");
        notVaccinatedReason.setVisible(false);

        otherReasonNoVaccine = new TextField("Other reasons not vaccinated?");
        otherReasonNoVaccine.setVisible(false);

        vaccinationStatus.addValueChangeListener(e -> {
            String value = e.getValue();
            boolean isVaccinated = "vaccinated".equals(value);
            boolean isNotVaccinated = "notVaccinated".equals(value);
            numberOfDiphtheriaContainingVaccine.setVisible(isVaccinated);
            dateOfLastVaccination.setVisible(isVaccinated);
            sourceOfVaccinationHistory.setVisible(isVaccinated);
            notVaccinatedReason.setVisible(isNotVaccinated);
            otherReasonNoVaccine.setVisible(false);
        });

        notVaccinatedReason.addValueChangeListener(e -> {
            boolean showOther = "others".equals(e.getValue());
            otherReasonNoVaccine.setVisible(showOther);
        });

        // Did the patient travel during or after illness?
        didThePatientTravelDuringOrAfterIllness = new RadioButtonGroup<>("Did the patient travel during or after illness?");
        didThePatientTravelDuringOrAfterIllness.setItems("yes", "no", "unknown");
        didThePatientTravelDuringOrAfterIllness.setRequired(true);
        didThePatientTravelDuringOrAfterIllness.setRequiredIndicatorVisible(true);

        clientAddress = new TextField("Travel address of patient during or after illness");
        clientAddress.setVisible(false);

        didThePatientTravelDuringOrAfterIllness.addValueChangeListener(e -> {
            clientAddress.setVisible("yes".equals(e.getValue()));
        });

        // Patient hospitalized or visit anyone in the hospital before illness?
        patientHospitalizedOrVisitAnyoneInTheHospitalBeforeIllness = new RadioButtonGroup<>("Patient hospitalized or visit anyone in the hospital before illness?");
        patientHospitalizedOrVisitAnyoneInTheHospitalBeforeIllness.setItems("yes", "no", "unknown");
        patientHospitalizedOrVisitAnyoneInTheHospitalBeforeIllness.setRequired(true);
        patientHospitalizedOrVisitAnyoneInTheHospitalBeforeIllness.setRequiredIndicatorVisible(true);

        hospitalizationStatus = new RadioButtonGroup<>("Hospitalization status");
        hospitalizationStatus.setItems("in-patient", "out-patient", "visitingFriend");
        hospitalizationStatus.setVisible(false);

        dateHospitalVisit = new DatePicker("Date of visit or hospitalization?");
        dateHospitalVisit.setMax(LocalDate.now());
        dateHospitalVisit.setVisible(false);

        nameOfHospital = new TextField("Name of hospital");
        nameOfHospital.setVisible(false);

        addressHospitalVisit = new TextField("Address of hospital visited or hospitalized in?");
        addressHospitalVisit.setVisible(false);

        patientHospitalizedOrVisitAnyoneInTheHospitalBeforeIllness.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            hospitalizationStatus.setVisible(show);
            dateHospitalVisit.setVisible(show);
            nameOfHospital.setVisible(show);
            addressHospitalVisit.setVisible(show);
        });

        // Was the patient admitted in the isolation ward?
        wasThePatientAdmittedInTheIsolationWard = new RadioButtonGroup<>("Was the patient admitted in the isolation ward?");
        wasThePatientAdmittedInTheIsolationWard.setItems("yes", "no", "unknown");
        wasThePatientAdmittedInTheIsolationWard.setRequired(true);
        wasThePatientAdmittedInTheIsolationWard.setRequiredIndicatorVisible(true);

        dateOfAdmissionPatientInIsolationWard = new DatePicker("Date of admission?");
        dateOfAdmissionPatientInIsolationWard.setMax(LocalDate.now());
        dateOfAdmissionPatientInIsolationWard.setVisible(false);

        dateOfDischargePatientInIsolationWard = new DatePicker("Date of discharge");
        dateOfDischargePatientInIsolationWard.setMax(LocalDate.now());
        dateOfDischargePatientInIsolationWard.setVisible(false);

        wasThePatientAdmittedInTheIsolationWard.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            dateOfAdmissionPatientInIsolationWard.setVisible(show);
            dateOfDischargePatientInIsolationWard.setVisible(show);
        });

        // Did case visit a traditional healer in 3weeks before onset
        locationTraditionalHealer = new RadioButtonGroup<>("Did case visit a traditional healer in 3 weeks before onset");
        locationTraditionalHealer.setItems("yes", "no", "unknown");
        locationTraditionalHealer.setRequired(true);
        locationTraditionalHealer.setRequiredIndicatorVisible(true);

        nameTraditionalHealer = new TextField("Name of traditional healer");
        nameTraditionalHealer.setVisible(false);

        addressTraditionalHealer = new TextField("Address of traditional healer");
        addressTraditionalHealer.setVisible(false);

        locationTraditionalHealer.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            nameTraditionalHealer.setVisible(show);
            addressTraditionalHealer.setVisible(show);
        });

        // Did the patient receive traditional medicine?
        traditionalMedicine = new RadioButtonGroup<>("Did the patient receive traditional medicine?");
        traditionalMedicine.setItems("yes", "no", "unknown");
        traditionalMedicine.setRequired(true);
        traditionalMedicine.setRequiredIndicatorVisible(true);

        traditionalMedicineType = new TextField("Traditional medicine type");
        traditionalMedicineType.setVisible(false);

        traditionalMedicine.addValueChangeListener(e -> {
            traditionalMedicineType.setVisible("yes".equals(e.getValue()));
        });

        // Did case attend funeral ceremonies anytime in the 3 weeks before illness?
        visitFuneralCeremonies = new RadioButtonGroup<>("Did case attend funeral ceremonies anytime in the 3 weeks before illness?");
        visitFuneralCeremonies.setItems("yes", "no", "unknown");
        visitFuneralCeremonies.setRequired(true);
        visitFuneralCeremonies.setRequiredIndicatorVisible(true);

        // Did the patient have contact with a known suspect / confirmed case anytime in the three weeks before becoming ill?
        contactSuspectConfirmed = new RadioButtonGroup<>("Did the patient have contact with a known suspect / confirmed case anytime in the three weeks before becoming ill?");
        contactSuspectConfirmed.setItems("yes", "no", "unknown");
        contactSuspectConfirmed.setRequired(true);
        contactSuspectConfirmed.setRequiredIndicatorVisible(true);

        epidCase = new TextField("Epid number of the case");
        epidCase.setVisible(false);

        contactSuspectConfirmed.addValueChangeListener(e -> {
            epidCase.setVisible("yes".equals(e.getValue()));
        });

        // Did the patient have contact with a wild animal (non-human primate or others)?
        animalContact = new RadioButtonGroup<>("Did the patient have contact with a wild animal (non-human primate or others)?");
        animalContact.setItems("yes", "no", "unknown");
        animalContact.setRequired(true);
        animalContact.setRequiredIndicatorVisible(true);

        kindAnimal = new TextField("Kind of animal");
        kindAnimal.setVisible(false);

        animalContact.addValueChangeListener(e -> {
            kindAnimal.setVisible("yes".equals(e.getValue()));
        });

        // Was the patient admitted in the isolation ward? (again, for outcome)
        wasThePatientAdmittedInTheIsolationWard2 = new RadioButtonGroup<>("Was the patient admitted in the isolation ward?");
        wasThePatientAdmittedInTheIsolationWard2.setItems("yes", "no", "unknown");
        wasThePatientAdmittedInTheIsolationWard2.setRequired(true);
        wasThePatientAdmittedInTheIsolationWard2.setRequiredIndicatorVisible(true);

        nameOfHospitalPatientAdmittedInIsolation = new TextField("Name of hospital");
        nameOfHospitalPatientAdmittedInIsolation.setVisible(false);

        dateOfAdmission = new DatePicker("Date of admission?");
        dateOfAdmission.setMax(LocalDate.now());
        dateOfAdmission.setVisible(false);

        dateOfDischarge = new DatePicker("Date of discharge");
        dateOfDischarge.setMax(LocalDate.now());
        dateOfDischarge.setVisible(false);

        outcome = new RadioButtonGroup<>("Outcome");
        outcome.setItems("alive", "dead");
        outcome.setVisible(false);

        dateOfPatientDeath = new DatePicker("Date of death");
        dateOfPatientDeath.setMax(LocalDate.now());
        dateOfPatientDeath.setVisible(false);

        wasThePatientAdmittedInTheIsolationWard2.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            nameOfHospitalPatientAdmittedInIsolation.setVisible(show);
            dateOfAdmission.setVisible(show);
            dateOfDischarge.setVisible(show);
            outcome.setVisible(show);
        });

        outcome.addValueChangeListener(e -> {
            dateOfPatientDeath.setVisible("dead".equals(e.getValue()));
        });

        // Add all components to the form
        form.add(
                vaccinationStatus,
                numberOfDiphtheriaContainingVaccine,
                dateOfLastVaccination,
                sourceOfVaccinationHistory,
                notVaccinatedReason,
                otherReasonNoVaccine,
                didThePatientTravelDuringOrAfterIllness,
                clientAddress,
                patientHospitalizedOrVisitAnyoneInTheHospitalBeforeIllness,
                hospitalizationStatus,
                dateHospitalVisit,
                nameOfHospital,
                addressHospitalVisit,
                wasThePatientAdmittedInTheIsolationWard,
                dateOfAdmissionPatientInIsolationWard,
                dateOfDischargePatientInIsolationWard,
                locationTraditionalHealer,
                nameTraditionalHealer,
                addressTraditionalHealer,
                traditionalMedicine,
                traditionalMedicineType,
                visitFuneralCeremonies,
                contactSuspectConfirmed,
                epidCase,
                animalContact,
                kindAnimal,
                wasThePatientAdmittedInTheIsolationWard2,
                nameOfHospitalPatientAdmittedInIsolation,
                dateOfAdmission,
                dateOfDischarge,
                outcome,
                dateOfPatientDeath
        );

        return form;
    }
}
