export default class AdminService {
    constructor(playersService) {
        'ngInject';

        this.playersService = playersService;
    }
}