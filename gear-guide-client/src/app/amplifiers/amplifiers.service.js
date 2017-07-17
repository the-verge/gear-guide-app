export default class AmplifiersService {
    constructor(amplifiersResource) {
        'ngInject';

        this.amplifiersResource = amplifiersResource;
    }

    getAmplifiers() {
        return this.amplifiersResource.get();
    }
}