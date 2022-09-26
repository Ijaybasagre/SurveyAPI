package com.myprojects.springboot.myfirstrestapi.Option;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceService {

    private final ChoiceRepository optionRepository;

    public ChoiceService(ChoiceRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public List<Choice> retrieveAllChoices() {
        return optionRepository.findAll();
    }

    public Choice retrieveChoiceById(Long choiceId) {
        return optionRepository.findById(choiceId)
                .orElseThrow(
                        () -> new RuntimeException(choiceId+" not found")
                );
    }

    public Choice createNewChoice(Choice choice){
        return optionRepository.save(choice);
    }
    public Choice updateOption(Long choiceId, Choice choice) {
        Choice opt = retrieveChoiceById(choiceId);
        if(choice.getPhrase() != null)
            opt.setPhrase(choice.getPhrase());
        return optionRepository.save(opt);
    }
    public void deleteChoice(Long choiceId) {
        optionRepository.deleteById(choiceId);
    }

}
