export default class PlayerDetailsService {
    constructor(playerResource) {
        'ngInject';

        this.playerResource = playerResource;
    }

    getPlayer(id) {
        return this.playerResource.getPlayer({id: id});
    }
}