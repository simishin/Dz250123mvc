package qwr.dz.logic;

import org.springframework.stereotype.Component;
import qwr.dz.entity.Answer;
import qwr.dz.entity.Demand;
@Component
public interface IAction {
    Answer action(Demand input);
}
