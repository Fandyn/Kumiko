var Main = {
    methods: {

        handleClick(row) {
            console.log(row);
            this.info = row.date;
            this.joke = row;
        },
        handleClickup(row) {
            this.form.name = row.name;
            this.form.address = row.address;
            this.form.date = row.date;
            this.dialogupdata = true;
        },
        //绝美的挽歌
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

        handleClose(done) {
            if (this.loading) {
                return;
            }
            this.$confirm('确定要提交表单吗？')
                .then(_ => {
                    this.loading = true;
                    this.timer = setTimeout(() => {
                        done();
                        // 动画关闭需要一定的时间
                        setTimeout(() => {
                            //真物
                            this.loading = false;
                        }, 400);
                        console.log("可乐"+"--"+this.form.name+"--"+this.form.sex+"--"+this.form.address+"--"+this.form.date);//动画过后执行
                        this.dialog = false;
                    }, 2000);
                    console.log("刻晴");//动画之前执行
                })
                .catch(_ => {});
            // console.log("默然");//确认之前执行
        },


        handleCloseone(done) {
            if (this.loading) {
                return;
            }
            this.$confirm('确定要提交表单吗？')
                .then(_ => {
                    this.loading = true;
                    this.timer = setTimeout(() => {
                        done();
                        setTimeout(() => {
                            this.loading = false;
                        }, 400);
                        console.log("可乐"+"--"+this.form.name+"--"+this.form.sex+"--"+this.form.address+"--"+this.form.date);//动画过后执行
                        //必须
                        this.dialog = false;
                    }, 2000);
                })
                .catch(_ => {});
        },


        cancelForm() {
            this.loading = false;
            this.dialog = false;
            this.dialogupdata = false;
            clearTimeout(this.timer);
            console.log("确认");
        }
    },

    data() {
        return {
            dialog: false,
            dialogupdata:false,
            loading: false,
            id:'10031',
            info:'this is test',
            joke:"hello",
            usernames:"",
            formInline: {
                user: '',
                region: ''
            },
            tableData: [{
                date: '2016-05-06',
                name: '加刻',
                address: '上海市普陀区金沙江路 1232 弄',
            }, {
                date: '2016-05-04',
                name: '刻晴',
                address: '上海市普陀区金沙江路 1234 弄'
            }, {
                date: '2016-01-01',
                name: '孤木',
                address: '上海市普陀区金沙江路 1256 弄',
            }, {
                date: '2016-08-02',
                name: '砂糖',
                address: '上海市普陀区金沙江路 7622 弄',
            }, {
                date: '2016-05-03',
                name: '风暴',
                address: '上海市普陀区金沙江路 7658 弄'
            }],
            form: {
                name: '',
                sex: '',
                address:'',
                date:'',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            formLabelWidth: '80px',
            timer: null,
        }
    }
}
var Ctor = Vue.extend(Main)
// $mount手动挂载
new Ctor().$mount('#app')
