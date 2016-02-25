package com.massivecraft.massivelight.cmd;

import java.util.List;

import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.VersionCommand;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivelight.MassiveLight;
import com.massivecraft.massivelight.Perm;
import com.massivecraft.massivelight.entity.MConf;

public class CmdLight extends MassiveCommand
{
	// -------------------------------------------- //
	// INSTANCE
	// -------------------------------------------- //
	
	private static CmdLight i = new CmdLight();
	public static CmdLight get() { return i; }
	
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public CmdLightFix cmdLightFix = new CmdLightFix();
	public VersionCommand cmdLightVersion = new VersionCommand(MassiveLight.get(), Perm.VERSION.node, "v", "version");
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdLight()
	{
		// Children
		this.addChild(this.cmdLightFix);
		this.addChild(this.cmdLightVersion);
		
		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.BASECOMMAND.node));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesLight;
	}

}
