package com.jacreator.disease_form.views.maternal_death;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class MaternalDeathClinicalHistoryView extends VerticalLayout {
private TextField fileNumber;
    private RadioButtonGroup<String> hospitalized;
    private DatePicker dateOfHospitalization;
    private DatePicker datePatientDied;
    private RadioButtonGroup<String> deceasedReferredFromOtherFacility;
    private TextField howLongDidItTake;
    private RadioButtonGroup<String> deceasedReceivedMedicalCare;
    private TextField whereAndTheTreatmentReceived;
    private TextField analysisAndInterpretationOfInformation;
    private ComboBox<String> suspectedCauseOfDeath;
    private RadioButtonGroup<String> abortionSpontaneousOrInduced;
    private ComboBox<String> timeOfDeath;
    private RadioButtonGroup<String> babyDeliveredAtTimeOfDeath;
    private ComboBox<String> conditionOfBabyAtTheTimeOfDelivery;
    private ComboBox<String> babyAliveOrDeadAfter28Days;
    private RadioButtonGroup<String> deceasedReceivedAntenatal;
    private RadioButtonGroup<String> motherOfDeceasedHaveMalaria;
    private RadioButtonGroup<String> haveHypertension;
    private RadioButtonGroup<String> haveAbnormalLife;
    private RadioButtonGroup<String> hivStatus;
    private TextField durationOfLabour;
    private ComboBox<String> typeOfDelivery;
    private CheckboxGroup<String> treatment;

    private static final List<String> treatmentData = Arrays.asList(
            "Fluids", "Plasma", "Blood Transfusion", "Antibiotics", "Ocytocin", "Anti-seizure drugs", "Oxygen",
            "Anti-malarial", "Other medical treatment", "Surgery", "Manual removal of placenta",
            "Manual intra uterin aspiration", "Curettage", "laporotomy", "hysterctomy",
            "intsrumental delivery (Forceps;Vacuum)", "Caesarian section",
            "anetshesia ( general, spinal, epidural , local)"
    );
    private static final List<String> deliveryTypeData = Arrays.asList(
            "Vaginal non-assisted-delivery",
            "Vaginal assisted-delivery (Vacuum/forceps)",
            "Caesarean section"
    );
    private static final List<String> babyAliveOrDeadData = Arrays.asList(
            "Still alive",
            "Neonatal death",
            "Died beyond 28 days of age"
    );
    private static final List<String> conditionData = Arrays.asList(
            "Alive",
            "Fresh Still birth",
            "Macerated still birth",
            "Not applicable"
    );
    private static final List<String> timeOfDeathData = Arrays.asList(
            "During pregnancy",
            "During delivery",
            "During the immediate post partum period, or long after delivery"
    );
    private static final List<String> causeOfDeathData = Arrays.asList(
            "Pre-eclampsia /eclampsia",
            "Puerperal sepsis",
            "Prolonged/Obstructed labour",
            "Ruptured uterus",
            "Complications of abortions",
            "Ectopic pregnancy",
            "Other specify"
    );

    public MaternalDeathClinicalHistoryView() {
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

        fileNumber = new TextField("Medical/File number");
        fileNumber.setRequired(true);
        fileNumber.setRequiredIndicatorVisible(true);

        hospitalized = new RadioButtonGroup<>("Hospitalized (Admitted)");
        hospitalized.setItems("yes", "no", "unknown");
        hospitalized.setRequired(true);
        hospitalized.setRequiredIndicatorVisible(true);

        dateOfHospitalization = new DatePicker("Date of hospitalization (if on admission/in-patient)");
        dateOfHospitalization.setMax(LocalDate.now());

        datePatientDied = new DatePicker("Date patient died");
        datePatientDied.setRequired(true);
        datePatientDied.setRequiredIndicatorVisible(true);
        datePatientDied.setMax(LocalDate.now());

        deceasedReferredFromOtherFacility = new RadioButtonGroup<>("Was the deceased referred from other health facility or hospital?");
        deceasedReferredFromOtherFacility.setItems("yes", "no", "unknown");
        deceasedReferredFromOtherFacility.setRequired(true);
        deceasedReferredFromOtherFacility.setRequiredIndicatorVisible(true);

        howLongDidItTake = new TextField("If yes, how long did it take to get here? (hours)");
        howLongDidItTake.setPattern("\\d*");

        deceasedReceivedMedicalCare = new RadioButtonGroup<>("Did the deceased receive any medical care or obstetrical/surgical interventions for what led to her death?");
        deceasedReceivedMedicalCare.setItems("yes", "no", "unknown");
        deceasedReceivedMedicalCare.setRequired(true);
        deceasedReceivedMedicalCare.setRequiredIndicatorVisible(true);

        whereAndTheTreatmentReceived = new TextField("If yes, specify where and the treatment received");

        analysisAndInterpretationOfInformation = new TextField("Analysis and interpretation of the information collected so far (investigator’s opinion on this death)");

        suspectedCauseOfDeath = new ComboBox<>("Suspected Cause of death");
        suspectedCauseOfDeath.setItems(causeOfDeathData);
        suspectedCauseOfDeath.setRequired(true);
        suspectedCauseOfDeath.setRequiredIndicatorVisible(true);

        abortionSpontaneousOrInduced = new RadioButtonGroup<>("If abortion: was it spontaneous or induced?");
        abortionSpontaneousOrInduced.setItems("Spontaneous", "Induced");

        timeOfDeath = new ComboBox<>("Time of death");
        timeOfDeath.setItems(timeOfDeathData);
        timeOfDeath.setRequired(true);
        timeOfDeath.setRequiredIndicatorVisible(true);

        babyDeliveredAtTimeOfDeath = new RadioButtonGroup<>("At the time of death, was the baby delivered?");
        babyDeliveredAtTimeOfDeath.setItems("Yes", "No");

        conditionOfBabyAtTheTimeOfDelivery = new ComboBox<>("Condition of the baby at the time of delivery");
        conditionOfBabyAtTheTimeOfDelivery.setItems(conditionData);

        babyAliveOrDeadAfter28Days = new ComboBox<>("In case the baby was born alive, is he/she still alive or died within 28 days after his/her birth?");
        babyAliveOrDeadAfter28Days.setItems(babyAliveOrDeadData);

        deceasedReceivedAntenatal = new RadioButtonGroup<>("Was the deceased receiving any antenatal care?");
        deceasedReceivedAntenatal.setItems("yes", "no", "unknown");
        deceasedReceivedAntenatal.setRequired(true);
        deceasedReceivedAntenatal.setRequiredIndicatorVisible(true);

        motherOfDeceasedHaveMalaria = new RadioButtonGroup<>("Did the mother of the deceased have malaria?");
        motherOfDeceasedHaveMalaria.setItems("yes", "no", "unknown");
        motherOfDeceasedHaveMalaria.setRequired(true);
        motherOfDeceasedHaveMalaria.setRequiredIndicatorVisible(true);

        haveHypertension = new RadioButtonGroup<>("Did she have Hypertension?");
        haveHypertension.setItems("yes", "no", "unknown");
        haveHypertension.setRequired(true);
        haveHypertension.setRequiredIndicatorVisible(true);

        haveAbnormalLife = new RadioButtonGroup<>("Did she have Abnormal Life?");
        haveAbnormalLife.setItems("yes", "no", "unknown");
        haveAbnormalLife.setRequired(true);
        haveAbnormalLife.setRequiredIndicatorVisible(true);

        hivStatus = new RadioButtonGroup<>("What was her HIV status?");
        hivStatus.setItems("positive", "negative", "unknown");
        hivStatus.setRequired(true);
        hivStatus.setRequiredIndicatorVisible(true);

        durationOfLabour = new TextField("How long (hours) was the duration of labor?");
        durationOfLabour.setPattern("\\d*");

        typeOfDelivery = new ComboBox<>("What type of delivery was it?");
        typeOfDelivery.setItems(deliveryTypeData);
        typeOfDelivery.setRequired(true);
        typeOfDelivery.setRequiredIndicatorVisible(true);

        treatment = new CheckboxGroup<>("Treatment [Please Tick as appropriate]");
        treatment.setItems(treatmentData);
        treatment.setRequired(true);
        treatment.setRequiredIndicatorVisible(true);

        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));

        form.add(
                fileNumber,
                hospitalized,
                dateOfHospitalization,
                datePatientDied,
                deceasedReferredFromOtherFacility,
                howLongDidItTake,
                deceasedReceivedMedicalCare,
                whereAndTheTreatmentReceived,
                analysisAndInterpretationOfInformation,
                suspectedCauseOfDeath,
                abortionSpontaneousOrInduced,
                timeOfDeath,
                babyDeliveredAtTimeOfDeath,
                conditionOfBabyAtTheTimeOfDelivery,
                babyAliveOrDeadAfter28Days,
                deceasedReceivedAntenatal,
                motherOfDeceasedHaveMalaria,
                haveHypertension,
                haveAbnormalLife,
                hivStatus,
                durationOfLabour,
                typeOfDelivery,
                treatment
        );


        return form;
    }
}
