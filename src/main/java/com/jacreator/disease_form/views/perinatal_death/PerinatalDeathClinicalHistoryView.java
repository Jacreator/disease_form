package com.jacreator.disease_form.views.perinatal_death;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class PerinatalDeathClinicalHistoryView extends VerticalLayout{
// Data for select/radio fields
    private static final List<String> causeOfDeathData = Arrays.asList("Cause 1", "Cause 2", "Cause 3");
    private static final List<String> yesNoUnknownData = Arrays.asList("Yes", "No", "Unknown");
    private static final List<String> birthWeightInGramsData = Arrays.asList(
            ">=2500", "1500-2499 (LBW)", "1000-1499g (VLBW)", "<1000 (ELBW)"
    );
    private static final List<String> deliveryTypeData = Arrays.asList(
            "Vaginal non-assisted-delivery",
            "Vaginal assisted-delivery (Vacuum/forceps)",
            "Caesarean section"
    );
    private static final List<String> typeOfPregnancyData = Arrays.asList("Singleton", "Twin", "Higher Multiples");
    private static final List<String> classificationOfPerinatalDeathData = Arrays.asList(
            "Neonatal death", "Fresh stillbirth", "Macerated stillbirth"
    );

    public PerinatalDeathClinicalHistoryView() {
        setWidthFull();
        
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Date Patient Died
        DatePicker datePatientDied = new DatePicker("Date Patient Died");
        datePatientDied.setMax(LocalDate.now());
        datePatientDied.setRequired(true);

        // Primary Cause of death
        ComboBox<String> primaryCauseOfDeath = new ComboBox<>("Primary Cause of death");
        primaryCauseOfDeath.setItems(causeOfDeathData);
        primaryCauseOfDeath.setPlaceholder("Select Primary Cause of death");
        primaryCauseOfDeath.setRequired(true);

        // Secondary Cause of death
        ComboBox<String> secondaryCauseOfDeath = new ComboBox<>("Secondary Cause of death");
        secondaryCauseOfDeath.setItems(causeOfDeathData);
        secondaryCauseOfDeath.setPlaceholder("Select Secondary Cause of death");
        secondaryCauseOfDeath.setRequired(true);

        // Other causes (specify)
        TextField otherCausesOfDeathSpecify = new TextField("Other causes (specify)");
        otherCausesOfDeathSpecify.setPlaceholder("Other causes (specify)");

        // Classification of perinatal/Newborn death
        ComboBox<String> classificationOfPerinatalDeath = new ComboBox<>("Classification of perinatal/Newborn death");
        classificationOfPerinatalDeath.setItems(classificationOfPerinatalDeathData);
        classificationOfPerinatalDeath.setPlaceholder("Select classification");
        classificationOfPerinatalDeath.setRequired(true);

        // Birth weight (in grams)
        TextField birthWeightInGrams = new TextField("Birth weight (in grams)");
        birthWeightInGrams.setPlaceholder("Birth weight (in grams)");
        birthWeightInGrams.setRequired(true);
        birthWeightInGrams.setPattern("\\d*");

        // Gestation at birth (in weeks)
        TextField gestationAtBirthInWeeks = new TextField("Gestation at birth (in weeks)");
        gestationAtBirthInWeeks.setPlaceholder("Gestation at birth (in weeks)");
        gestationAtBirthInWeeks.setRequired(true);
        gestationAtBirthInWeeks.setPattern("\\d*");

        // Date of Birth
        DatePicker dateOfBirth = new DatePicker("Date of Birth");
        dateOfBirth.setMax(LocalDate.now());
        dateOfBirth.setRequired(true);

        // Date of hospitalization (admission)
        DatePicker dateOfHospitalization = new DatePicker("Date of hospitalization (admission)");
        dateOfHospitalization.setMax(LocalDate.now());
        dateOfHospitalization.setRequired(true);

        // Date of Death
        DatePicker dateOfDeath = new DatePicker("Date of Death");
        dateOfDeath.setMax(LocalDate.now());
        dateOfDeath.setRequired(true);

        // Type of pregnancy
        ComboBox<String> typeOfPregnancy = new ComboBox<>("Type of pregnancy");
        typeOfPregnancy.setItems(typeOfPregnancyData);
        typeOfPregnancy.setPlaceholder("Select Type of pregnancy");
        typeOfPregnancy.setRequired(true);

        // Did the mother of the deceased receive any antenatal care?
        ComboBox<String> motherReceivedAntenatalCare = new ComboBox<>("Did the mother of the deceased receive any antenatal care?");
        motherReceivedAntenatalCare.setItems(yesNoUnknownData);
        motherReceivedAntenatalCare.setPlaceholder("Select option");
        motherReceivedAntenatalCare.setRequired(true);

        // If yes to the above question, how many visits?
        TextField howManyAntenatalVisits = new TextField("If yes to the above question, how many visits?");
        howManyAntenatalVisits.setPlaceholder("How many antenatal visits?");
        howManyAntenatalVisits.setPattern("\\d*");

        // Did the mother of the deceased have malaria?
        RadioButtonGroup<String> motherOfDeceasedHaveMalaria = new RadioButtonGroup<>();
        motherOfDeceasedHaveMalaria.setLabel("Did the mother of the deceased have malaria?");
        motherOfDeceasedHaveMalaria.setItems(yesNoUnknownData);
        motherOfDeceasedHaveMalaria.setRequired(true);

        // If yes to question above, did the mother receive treatment
        RadioButtonGroup<String> motherOfDeceasedReceivedMalariaTreatment = new RadioButtonGroup<>();
        motherOfDeceasedReceivedMalariaTreatment.setLabel("If yes to question above, did the mother receive treatment?");
        motherOfDeceasedReceivedMalariaTreatment.setItems(yesNoUnknownData);
        motherOfDeceasedReceivedMalariaTreatment.setRequired(true);

        // Did the mother of the deceased have pre-eclampsia disease?
        RadioButtonGroup<String> motherOfDeceasedHavePreeclamsiaDisease = new RadioButtonGroup<>();
        motherOfDeceasedHavePreeclamsiaDisease.setLabel("Did the mother of the deceased have pre-eclampsia disease?");
        motherOfDeceasedHavePreeclamsiaDisease.setItems(yesNoUnknownData);
        motherOfDeceasedHavePreeclamsiaDisease.setRequired(true);

        // If yes to the question above, did the mother receive any treatment?
        RadioButtonGroup<String> motherOfDeceasedReceivedPreeclampsiaTreatment = new RadioButtonGroup<>();
        motherOfDeceasedReceivedPreeclampsiaTreatment.setLabel("If yes to the question above, did the mother receive any treatment?");
        motherOfDeceasedReceivedPreeclampsiaTreatment.setItems(yesNoUnknownData);
        motherOfDeceasedReceivedPreeclampsiaTreatment.setRequired(true);

        // Did the mother of the deceased have severe anaemia (HB,7g/dl)
        RadioButtonGroup<String> motherOfDeceasedHaveSeverAnaemia = new RadioButtonGroup<>();
        motherOfDeceasedHaveSeverAnaemia.setLabel("Did the mother of the deceased have severe anaemia (HB,7g/dl)");
        motherOfDeceasedHaveSeverAnaemia.setItems(yesNoUnknownData);
        motherOfDeceasedHaveSeverAnaemia.setRequired(true);

        // If yes to the question above, did the mother receive any treatment?
        RadioButtonGroup<String> motherOfDeceasedReceiveSeverAnaemiaTreatment = new RadioButtonGroup<>();
        motherOfDeceasedReceiveSeverAnaemiaTreatment.setLabel("If yes to the question above, did the mother receive any treatment?");
        motherOfDeceasedReceiveSeverAnaemiaTreatment.setItems(yesNoUnknownData);
        motherOfDeceasedReceiveSeverAnaemiaTreatment.setRequired(true);

        // Did the mother of the deceased have recommended maternal immunizations (e.g. tetanus toxoid)
        RadioButtonGroup<String> motherOfDeceasedHaveMaternalImmunizations = new RadioButtonGroup<>();
        motherOfDeceasedHaveMaternalImmunizations.setLabel("Did the mother of the deceased have recommended maternal immunizations (e.g. tetanus toxoid)");
        motherOfDeceasedHaveMaternalImmunizations.setItems(yesNoUnknownData);
        motherOfDeceasedHaveMaternalImmunizations.setRequired(true);

        // If Rhesus positive, did the mother of the deceased receive Anti-D injection during this baby’s pregnancy?
        RadioButtonGroup<String> motherOfDeceasedReceiveAntiDInjection = new RadioButtonGroup<>();
        motherOfDeceasedReceiveAntiDInjection.setLabel("If Rhesus positive, did the mother of the deceased receive Anti-D injection during this baby’s pregnancy?");
        motherOfDeceasedReceiveAntiDInjection.setItems(yesNoUnknownData);
        motherOfDeceasedReceiveAntiDInjection.setRequired(true);

        // What was the HIV status of the mother?
        RadioButtonGroup<String> hivStatusOfMother = new RadioButtonGroup<>();
        hivStatusOfMother.setLabel("What was the HIV status of the mother?");
        hivStatusOfMother.setItems("HIV+", "HIV-", "Unknown");
        hivStatusOfMother.setRequired(true);

        // What was the status of the syphilis test of mother?
        RadioButtonGroup<String> syphilisStatusOfMother = new RadioButtonGroup<>();
        syphilisStatusOfMother.setLabel("What was the status of the syphilis test of mother?");
        syphilisStatusOfMother.setItems("+Ve", "-Ve", "Unknown");
        syphilisStatusOfMother.setRequired(true);

        // Date of Birth 2
        DatePicker dateOfBirth2 = new DatePicker("Date of Birth");
        dateOfBirth2.setMax(LocalDate.now());
        dateOfBirth2.setRequired(true);

        // Attendance at delivery
        RadioButtonGroup<String> attendanceAtDelivery = new RadioButtonGroup<>();
        attendanceAtDelivery.setLabel("Attendance at delivery");
        attendanceAtDelivery.setItems("Nurse", "Midwife", "Doctor", "Other (specify)");
        attendanceAtDelivery.setRequired(true);

        // If other, please specify
        TextField attendanceOtherSpecify = new TextField("If other, please specify");
        attendanceOtherSpecify.setPlaceholder("Specify other attendance");

        // Was fetal heart rate assessed on admission?
        RadioButtonGroup<String> fetalHeartRateAssessed = new RadioButtonGroup<>();
        fetalHeartRateAssessed.setLabel("Was fetal heart rate assessed on admission?");
        fetalHeartRateAssessed.setItems("Yes", "No");
        fetalHeartRateAssessed.setRequired(true);

        // What type of delivery was it?
        ComboBox<String> typeOfDelivery = new ComboBox<>("What type of delivery was it?");
        typeOfDelivery.setItems(deliveryTypeData);
        typeOfDelivery.setPlaceholder("Select Type");
        typeOfDelivery.setRequired(true);

        // Birth weight in grams
        ComboBox<String> birthWeightInGrams2 = new ComboBox<>("Birth weight in grams");
        birthWeightInGrams2.setItems(birthWeightInGramsData);
        birthWeightInGrams2.setPlaceholder("Select Weight Range");
        birthWeightInGrams2.setRequired(true);

        // Did the mother of the deceased have premature rupture of membranes (PROM)
        RadioButtonGroup<String> havePrematureRuptureOfMembrane = new RadioButtonGroup<>();
        havePrematureRuptureOfMembrane.setLabel("Did the mother of the deceased have premature rupture of membranes (PROM)");
        havePrematureRuptureOfMembrane.setItems(yesNoUnknownData);
        havePrematureRuptureOfMembrane.setRequired(true);

        // Gestation at birth (in weeks) 2
        TextField gestationAtBirthInWeeks2 = new TextField("Gestation at birth (in weeks)");
        gestationAtBirthInWeeks2.setPlaceholder("Gestation at birth (in weeks)");
        gestationAtBirthInWeeks2.setRequired(true);
        gestationAtBirthInWeeks2.setPattern("\\d*");

        // If stillbirth – gestational age (in weeks) of the deceased
        TextField gestationAtBirthInWeeksIfStillbirth = new TextField("If stillbirth – gestational age (in weeks) of the deceased");
        gestationAtBirthInWeeksIfStillbirth.setPlaceholder("Gestation at birth (in weeks), if stillbirth");
        gestationAtBirthInWeeksIfStillbirth.setRequired(true);
        gestationAtBirthInWeeksIfStillbirth.setPattern("\\d*");

        // Date of hospitalization (admission) 2
        DatePicker dateOfHospitalization2 = new DatePicker("Date of hospitalization (admission)");
        dateOfHospitalization2.setMax(LocalDate.now());
        dateOfHospitalization2.setRequired(true);

        // How long (hours) was the duration of labor
        TextField durationOfLabour = new TextField("How long (hours) was the duration of labor");
        durationOfLabour.setPlaceholder("How long (hours) was the duration of labor");
        durationOfLabour.setRequired(true);
        durationOfLabour.setPattern("\\d*");

        // If neonatal – gestational age (in weeks) of the deceased
        TextField gestationAtBirthInWeeksIfNeonatal = new TextField("If neonatal – gestational age (in weeks) of the deceased");
        gestationAtBirthInWeeksIfNeonatal.setPlaceholder("Gestation at birth (in weeks), if neonatal death");
        gestationAtBirthInWeeksIfNeonatal.setRequired(true);
        gestationAtBirthInWeeksIfNeonatal.setPattern("\\d*");

        // If the deceased baby was born alive what was the APGAR Score?
        TextField apgarScore = new TextField("If the deceased baby was born alive what was the APGAR Score?");
        apgarScore.setPlaceholder("Enter APGAR Score");
        apgarScore.setRequired(true);

        // If the deceased baby was born alive, was resuscitation with bag and mask conducted?
        RadioButtonGroup<String> resuscitationWithBagAndMaskConducted = new RadioButtonGroup<>();
        resuscitationWithBagAndMaskConducted.setLabel("If the deceased baby was born alive, was resuscitation with bag and mask conducted?");
        resuscitationWithBagAndMaskConducted.setItems("Yes", "No");
        resuscitationWithBagAndMaskConducted.setRequired(true);

        // If the deceased baby was born alive was he/she referred to any health facility or hospital?
        RadioButtonGroup<String> babyAliveReferedToFacility = new RadioButtonGroup<>();
        babyAliveReferedToFacility.setLabel("If the deceased baby was born alive was he/she referred to any health facility or hospital?");
        babyAliveReferedToFacility.setItems("Yes", "No", "Unknown");
        babyAliveReferedToFacility.setRequired(true);

        // If the deceased baby was born alive did he/she receive any other medical care beyond resuscitation?
        RadioButtonGroup<String> babyReceivedOtherMedicalCare = new RadioButtonGroup<>();
        babyReceivedOtherMedicalCare.setLabel("If the deceased baby was born alive did he/she receive any other medical care beyond resuscitation?");
        babyReceivedOtherMedicalCare.setItems("Yes", "No", "Unknown");
        babyReceivedOtherMedicalCare.setRequired(true);

        // If yes, specify where and the treatment received
        TextField whereAndOtherTreatmentReceived = new TextField("If yes, specify where and the treatment received");
        whereAndOtherTreatmentReceived.setPlaceholder("Please specify where and the treatment received");

        // Primary Cause of death 2
        ComboBox<String> primaryCauseOfDeath2 = new ComboBox<>("Primary Cause of death");
        primaryCauseOfDeath2.setItems(causeOfDeathData);
        primaryCauseOfDeath2.setPlaceholder("Select Primary Cause of death");
        primaryCauseOfDeath2.setRequired(true);

        // Secondary Cause of death 2
        ComboBox<String> secondaryCauseOfDeath2 = new ComboBox<>("Secondary Cause of death");
        secondaryCauseOfDeath2.setItems(causeOfDeathData);
        secondaryCauseOfDeath2.setPlaceholder("Select Secondary Cause of death");
        secondaryCauseOfDeath2.setRequired(true);

        // Maternal condition (if applicable)
        TextField maternalCondition = new TextField("Maternal condition (if applicable)");
        maternalCondition.setPlaceholder("Enter condition");

        // Any physical malformation noted on the deceased?
        RadioButtonGroup<String> physicalMalformation = new RadioButtonGroup<>();
        physicalMalformation.setLabel("Any physical malformation noted on the deceased?");
        physicalMalformation.setItems("Yes", "No");
        physicalMalformation.setRequired(true);

        // If yes, type of birth defect (with full description)
        TextField typeOfBirthDefectWithDescription = new TextField("If yes, type of birth defect (with full description)");
        typeOfBirthDefectWithDescription.setPlaceholder("Describe the birth defect");
        typeOfBirthDefectWithDescription.setRequired(true);

        // Analysis and interpretation of the information collected so far (investigator’s opinion on this death)
        TextField analysisAndInterpretationOfInformation = new TextField("Analysis and interpretation of the information collected so far (investigator’s opinion on this death)");
        analysisAndInterpretationOfInformation.setPlaceholder("State analysis and interpretation of information");

        // Add all fields to the form
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));
        form.add(
                datePatientDied, primaryCauseOfDeath, secondaryCauseOfDeath, otherCausesOfDeathSpecify,
                classificationOfPerinatalDeath, birthWeightInGrams, gestationAtBirthInWeeks, dateOfBirth,
                dateOfHospitalization, dateOfDeath, typeOfPregnancy, motherReceivedAntenatalCare,
                howManyAntenatalVisits, motherOfDeceasedHaveMalaria, motherOfDeceasedReceivedMalariaTreatment,
                motherOfDeceasedHavePreeclamsiaDisease, motherOfDeceasedReceivedPreeclampsiaTreatment,
                motherOfDeceasedHaveSeverAnaemia, motherOfDeceasedReceiveSeverAnaemiaTreatment,
                motherOfDeceasedHaveMaternalImmunizations, motherOfDeceasedReceiveAntiDInjection,
                hivStatusOfMother, syphilisStatusOfMother, dateOfBirth2, attendanceAtDelivery,
                attendanceOtherSpecify, fetalHeartRateAssessed, typeOfDelivery, birthWeightInGrams2,
                havePrematureRuptureOfMembrane, gestationAtBirthInWeeks2, gestationAtBirthInWeeksIfStillbirth,
                dateOfHospitalization2, durationOfLabour, gestationAtBirthInWeeksIfNeonatal, apgarScore,
                resuscitationWithBagAndMaskConducted, babyAliveReferedToFacility, babyReceivedOtherMedicalCare,
                whereAndOtherTreatmentReceived, primaryCauseOfDeath2, secondaryCauseOfDeath2, maternalCondition,
                physicalMalformation, typeOfBirthDefectWithDescription, analysisAndInterpretationOfInformation
        );

        return form;
    }
}
