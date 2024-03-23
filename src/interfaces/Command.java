package interfaces;

import enums.ReadModes;

public interface Command {
    void execute(ReadModes readMode);
    String getDesc();
    String getUsage();
}
