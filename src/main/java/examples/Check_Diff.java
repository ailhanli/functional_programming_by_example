package examples;

import java.util.Arrays;

public class Check_Diff {

	public static void main(String[] args) {
		
		String[] original = {
				
				"  act_seq                  NUMBER not null,",
				"  member_id                VARCHAR2(16 CHAR) not null,",
				"  tier                     VARCHAR2(5 CHAR),",
				"  activity_type            CHAR(1 CHAR),",
				"  activity_date            DATE,",
				"  company                  VARCHAR2(10 CHAR),",
				"  activity_classification  VARCHAR2(10 CHAR),",
				"  award_miles              NUMBER,",
				"  qualifying_miles         NUMBER,",
				"  qualifying_sectors       NUMBER,",
				"  definition               VARCHAR2(100 CHAR),",
				"  status                   VARCHAR2(2 CHAR) not null,",
				"  origin                   VARCHAR2(3 CHAR),",
				"  destination              VARCHAR2(3 CHAR),",
				"  booking_class            VARCHAR2(1 CHAR),",
				"  flown_class              VARCHAR2(1 CHAR),",
				"  flt_number               VARCHAR2(7 CHAR),",
				"  pnr                      VARCHAR2(6 CHAR),",
				"  ticket_number            VARCHAR2(35 CHAR),",
				"  billing_base             NUMBER,",
				"  billing_bonus            NUMBER,",
				"  explanation              VARCHAR2(255 CHAR),",
				"  cut_date                 DATE,",
				"  entry_type               CHAR(1),",
				"  partner_seq              VARCHAR2(20 CHAR),",
				"  coupon_fare              NUMBER,",
				"  expire_processed         VARCHAR2(1 CHAR),",
				"  expire_date              DATE,",
				"  booking_date             DATE,",
				"  booking_office_id        VARCHAR2(25 CHAR),",
				"  transaction_flyer_id     VARCHAR2(16 CHAR),",
				"  transaction_activity_seq NUMBER,",
				"  merged_member_id         VARCHAR2(16 CHAR),",
				"  pax_name                 VARCHAR2(60 CHAR),",
				"  transaction_location     VARCHAR2(100 CHAR),",
				"  sales_values             NUMBER,",
				"  checkin_date             DATE,",
				"  checkout_date            DATE,",
				"  adjustment_code          VARCHAR2(10 CHAR),",
				"  rev_acc_process_date     DATE,",
				"  invoiced                 VARCHAR2(1 CHAR),",
				"  user_name                VARCHAR2(30 CHAR),",
				"  entry_time               DATE,",
				"  is_transferred           VARCHAR2(1 CHAR),",
				"  used_all                 VARCHAR2(1 CHAR),",
				"  promotion_code           VARCHAR2(30 CHAR),",
				"  used_points              NUMBER not null,",
				"  correction_done          VARCHAR2(1) not null,",
				"  correction_act_seq       NUMBER,",
				"  sales_agent_id           VARCHAR2(25),",
				"  inserted_by              VARCHAR2(20 CHAR),",
				"  insert_date              DATE,",
				"  amended_by               VARCHAR2(20 CHAR),",
				"  amend_date               DATE,",
				"  replica_ts               TIMESTAMP(6),",
				"  replica_seq              NUMBER,",
				"  brand_code               VARCHAR2(13)"
				
		};
		
		String[] replica = {
				
				"  act_seq                  NUMBER not null,",
				"  flyer_id                 VARCHAR2(16 CHAR),",
				"  activity_type            CHAR(1 CHAR),",
				"  activity_date            DATE,",
				"  company                  VARCHAR2(10 CHAR) not null,",
				"  activity_classification  VARCHAR2(10 CHAR),",
				"  points                   NUMBER default 0,",
				"  miles                    NUMBER default 0,",
				"  flt_count                NUMBER default 0,",
				"  definition               VARCHAR2(100 CHAR),",
				"  status                   VARCHAR2(2 CHAR) default 'OK' not null,",
				"  origin                   VARCHAR2(3 CHAR),",
				"  destination              VARCHAR2(3 CHAR),",
				"  class_code               VARCHAR2(1 CHAR),",
				"  flown_class              VARCHAR2(1 CHAR),",
				"  flt_number               VARCHAR2(7 CHAR),",
				"  pnr                      VARCHAR2(10 CHAR),",
				"  referance                VARCHAR2(35 CHAR),",
				"  billing_base             NUMBER,",
				"  billing_bonus            NUMBER,",
				"  explanation              VARCHAR2(255 CHAR),",
				"  cut_date                 DATE,",
				"  acc_no                   VARCHAR2(16 CHAR),",
				"  flyer_card_type          VARCHAR2(5 CHAR),",
				"  entry_type               CHAR(1),",
				"  partner_seq              VARCHAR2(20 CHAR),",
				"  coupon_fare              NUMBER,",
				"  expire_processed         VARCHAR2(1 CHAR),",
				"  expire_date              DATE,",
				"  accounting_seq           NUMBER,",
				"  finance_transaction_seq  NUMBER,",
				"  booking_date             DATE,",
				"  booking_office_id        VARCHAR2(25 CHAR),",
				"  transaction_flyer_id     VARCHAR2(16 CHAR),",
				"  transaction_activity_seq NUMBER,",
				"  pax_name                 VARCHAR2(100),",
				"  transaction_location     VARCHAR2(100 CHAR),",
				"  sales_values             NUMBER,",
				"  checkin_date             DATE,",
				"  checkout_date            DATE,",
				"  adjustment_code          VARCHAR2(10 CHAR),",
				"  rev_acc_process_date     DATE,",
				"  invoiced                 VARCHAR2(1 CHAR) default 'F',",
				"  manual_base_points       NUMBER,",
				"  manual_bonus_points      NUMBER,",
				"  manual_tier_points       NUMBER,",
				"  user_name                VARCHAR2(30 CHAR),",
				"  entry_time               DATE default sysdate,",
				"  inserted_by              VARCHAR2(20 CHAR),",
				"  insert_date              DATE,",
				"  amended_by               VARCHAR2(20 CHAR),",
				"  amend_date               DATE,",
				"  plat_miles               NUMBER default 0,",
				"  plat_flt_count           NUMBER default 0,",
				"  is_transferred           VARCHAR2(1 CHAR),",
				"  used_all                 VARCHAR2(1 CHAR),",
				"  promotion_code           VARCHAR2(30 CHAR),",
				"  used_points              NUMBER default 0 not null,",
				"  migration_reference      VARCHAR2(20),",
				"  correction_done          VARCHAR2(1) default 'F' not null,",
				"  correction_act_seq       NUMBER,",
				"  sales_agent_id           VARCHAR2(25),",
				"  charge_to_partner        VARCHAR2(1 CHAR),",
				"  replica_ts               TIMESTAMP(6),",
				"  replica_seq              NUMBER,",
				"  sap_invoiced             VARCHAR2(1),",
				"  brand_code               VARCHAR2(13)"
		};
		
		
		Arrays
		.stream(original)
		.map(String::trim)
		.map(s->s.split("\\s+")[0])
		//.peek(System.out::println)
		.filter(s-> 
					Arrays
					.stream(replica)
					.map(String::trim)
					.map(sp->sp.split("\\s+")[0])
					.filter(rp->rp.equals(s))
					//.peek(System.out::println)
					.findAny()
					.orElse(null)==null)
		.forEach(s->System.out.println(s));
		
		
		
		
	}
}