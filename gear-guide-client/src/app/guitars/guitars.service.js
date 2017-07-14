export default class GuitarsService {
    constructor(guitarsResource) {
        'ngInject';

        this.guitarsResource = guitarsResource;
    }

    getGuitars() {
        return this.guitarsResource.get();
    }

    createGuitar(guitarData) {
        return this.guitarsResource.create(guitarData).$promise;
    }

}