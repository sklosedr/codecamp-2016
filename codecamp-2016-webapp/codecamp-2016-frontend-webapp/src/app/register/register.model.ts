export class Register {
    constructor(
        public id: number,
        public username: string,
        public password: string,
        public userRole: string,
        public name: string,
        public favoriteToy: string,
        public description: string,
        public goodDog: boolean
    ) { }
}