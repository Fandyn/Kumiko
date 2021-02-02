var Main = {
    methods: {
        tableRowClassName({row, rowIndex}) {
            if (rowIndex === 1) {
                return 'warning-row';
            } else if (rowIndex === 3) {
                return 'success-row';
            }
            return '';
        },
        onSubmit() {
            console.log('submit!');
        },
        getPost: function () {
            let that = this;
            let name=this.usernames;
            axios.post('https://autumnfish.cn/api/user/reg', {username: that.usernames})
                .then(function (res) {
                    that.joke = res.data;
                    if (res.data == "注册成功") {
                        that.joke="没想到吧jojo，这就是我的逃跑路线!!!!!!!!!!!!!!!!!";
                    }
                    if (res.data=="已被注册，请检查") {
                        that.joke="这里已经满员了!!!!!!!!!!!!!!!!!";
                    }
                }, function (err) {
                    that.joke=err;
                });
        },
    },

    data() {
        return {
            id:'10031',
            info:'this is test',
            joke:"hello",
            usernames:"",
            formInline: {
                user: '',
                region: ''
            },
            tableData: [{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄',
            }, {
                date: '2016-05-04',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄',
            }, {
                date: '2016-05-03',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }]
        }
    }
}
var Ctor = Vue.extend(Main)
// $mount手动挂载
new Ctor().$mount('#app')
