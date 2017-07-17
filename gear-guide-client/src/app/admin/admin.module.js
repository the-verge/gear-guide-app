const moduleName = 'app.admin';

import AdminController from './admin.controller';
import AdminService from './admin.service';

angular.module(moduleName, [])
    .controller('adminController', AdminController)
    .service('adminService', AdminService)
    .constant('PLAYER_INPUT', 'player-img')
    .constant('GUITAR_INPUT', 'guitar-img')
    .constant('AMPLIFIER_INPUT', 'amplifier-img');

export default moduleName;