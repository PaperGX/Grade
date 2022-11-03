package fr.papergx.grade;

public enum GradeList {
    FONDATEUR(14,"§4§lFondateur§4", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    ADMINISTRATEUR(13, "§c§lAdministrateur§c", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    COMMUNITYMANAGER(12, "§6§lCommunity-Manager§6", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    RESPONSABLE(11, "§9§lResponsable§9", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    MODERATEURPLUS(10, "§2§lModérateur+§2", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    MODERATEUR(9, "§a§lModérateur§a", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    HELPER(8, "§b§lHelper§b", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),

    PARTENAIRE(7, "§d§lPartenaire§d", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    YOUTUBEURPLUS(6, "§f§lYou§c§lTubeur+§c", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    YOUTUBEUR(5, "§f§lYou§c§lTubeur§f", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    ROI(4, "§e§lRoi§e", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    PRINCE(3, "§5§lPrince§5", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    NOBLE(2, "§3§lNoble§3", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    CHEVALIER(1, "§8§lChevalier§8", new String[] {"taperm1", "taperm2", "et ainsi de suite"}),
    RECRUE(0, "§7§lRecrue§7", new String[] {});

    private final int power;
    private final String prefix;
    private final String[] permissions;

    private GradeList(final int power,final String prefix,final String[] permissions) {
        this.power = power;
        this.prefix = prefix;
        this.permissions = permissions;
    }

    public final int getPower() {
        return power;
    }
    public final String getPrefix(){
        return prefix;
    }
    
    public String[] getPermissions() {
		return permissions;
	}
    
    public final String getName(){
        return this.toString();
    }

}
