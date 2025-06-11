class Country { //type safety risultati che sono sicuro che rientrino parametri
    countryId;
    probability;
    constructor(id, prob){
        this.countryId = id;
        this.probability = prob;
    }
    getDescrizioneCountry() {   //il metodo mi permette di evitare di ripetere
        return `Stato: ${this.countryId} - Probabilità: ${this.probability}`;
    }
}