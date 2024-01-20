package customdata;

import necesse.engine.commands.CmdParameter;
import necesse.engine.commands.CommandLog;
import necesse.engine.commands.ModularChatCommand;
import necesse.engine.commands.PermissionLevel;
import necesse.engine.commands.parameterHandlers.IntParameterHandler;
import necesse.engine.commands.parameterHandlers.PresetStringParameterHandler;
import necesse.engine.network.client.Client;
import necesse.engine.network.server.Server;
import necesse.engine.network.server.ServerClient;

public class CommandWorldData extends ModularChatCommand {
    public CommandWorldData() {
        super("worlddata", "World Data", PermissionLevel.USER, false,
                new CmdParameter("cmd", new PresetStringParameterHandler("set", "get")),
                new CmdParameter("data", new IntParameterHandler(0), true)
        );
    }

    @Override
    public void runModular(Client client, Server server, ServerClient serverClient, Object[] args, String[] errors, CommandLog log) {
        String cmd = (String) args[0];
        int value = (int) args[1];

        switch (cmd) {
            case "set":
                CustomWorldData.getCustomWorldData(server).data = value;
                log.add("Set world data to: " + value);
                break;
            case "get":
                int data = CustomWorldData.getCustomWorldData(server).data;
                log.add("Existing world data: " + data);
                break;
            default:
                log.add("Unknown world data command: " + cmd);
        }
    }
}
