package org.AbsterGo.api;

/**
 *
 * Administrator
 */
public enum EmailSendType {

	// Mail
	REG_PASSWD() {

		@Override
		public String toString() {
			return "注册激活_密码找回";
		}
	},
	// Mail1
	START_FAIL_FULL_LOAN() {

		@Override
		public String toString() {
			return "放标_流标_满标";
		}
	},
	IN_REPAY_RECEIVED_REPAY() {

		@Override
		public String toString() {
			return "提前还款_收到还款";
		}
	},
	// Mail2
	OVER_DUE_TIP() {

		@Override
		public String toString() {
			return "逾期_还款提醒";
		}
	},
	REPAY_SUCCESS() {

		@Override
		public String toString() {
			return "成功还款";
		}
	},
	TIMER_REDMONEY() {

		@Override
		public String toString() {
			return "发送定时红包";
		}
	},
	GROUP_REDMONEY() {

		@Override
		public String toString() {
			return "群发红包";
		}
	},
	LOAN_HOBBY() {

		@Override
		public String toString() {
			return "个人喜好";
		}
	},
	REGISTER_REDMONEY() {

		@Override
		public String toString() {
			return "注册送红包";
		}
	},
	INVITE_REDMONEY() {

		@Override
		public String toString() {
			return "邀请好友送红包";
		}
	},
	ACTIVITY() {

		@Override
		public String toString() {
			return "参加网站举办活动";
		}
	},
	OTHER() {

		@Override
		public String toString() {
			return "其他";
		}
	};

	@Override
	public abstract String toString();
}
