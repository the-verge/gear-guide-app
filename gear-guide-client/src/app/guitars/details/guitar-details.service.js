export default class GuitarDetailsService {
    constructor(guitarsResource) {
        'ngInject';

        this.guitarsResource = guitarsResource;
    }

    loadGuitar(id) {
        return this.guitarsResource.getGuitar(id);
    }
}