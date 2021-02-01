package org.eclipse.kura.linux.net.iptables;

public class IptablesConfigConstants {

    protected static final String FIREWALL_CONFIG_FILE_NAME = "/etc/sysconfig/iptables";
    protected static final String FIREWALL_TMP_CONFIG_FILE_NAME = "/tmp/iptables";
    protected static final String FILTER = "filter";
    protected static final String NAT = "nat";
    protected static final String MANGLE = "mangle";
    protected static final String STAR_NAT = "*" + NAT;
    protected static final String STAR_FILTER = "*" + FILTER;
    protected static final String STAR_MANGLE = "*" + MANGLE;
    protected static final String COMMIT = "COMMIT";
    protected static final String IPTABLES_COMMAND = "iptables";
    protected static final String FORWARD = "FORWARD";
    protected static final String INPUT = "INPUT";
    protected static final String OUTPUT = "OUTPUT";
    protected static final String PREROUTING = "PREROUTING";
    protected static final String POSTROUTING = "POSTROUTING";
    protected static final String RETURN = "RETURN";
    protected static final String INPUT_KURA_CHAIN = "input-kura";
    protected static final String OUTPUT_KURA_CHAIN = "output-kura";
    protected static final String FORWARD_KURA_CHAIN = "forward-kura";
    protected static final String PREROUTING_KURA_CHAIN = "prerouting-kura";
    protected static final String POSTROUTING_KURA_CHAIN = "postrouting-kura";
    protected static final String ADD_INPUT_KURA_CHAIN = "-I INPUT -j input-kura";
    protected static final String ADD_OUTPUT_KURA_CHAIN = "-I OUTPUT -j output-kura";
    protected static final String ADD_FORWARD_KURA_CHAIN = "-I FORWARD -j forward-kura";
    protected static final String ADD_PREROUTING_KURA_CHAIN = "-I PREROUTING -j prerouting-kura";
    protected static final String ADD_POSTROUTING_KURA_CHAIN = "-I POSTROUTING -j postrouting-kura";
    protected static final String RETURN_PREROUTING_KURA_CHAIN = "-A prerouting-kura -j RETURN";
    protected static final String RETURN_POSTROUTING_KURA_CHAIN = "-A postrouting-kura -j RETURN";
    protected static final String RETURN_INPUT_KURA_CHAIN = "-A input-kura -j RETURN";
    protected static final String RETURN_OUTPUT_KURA_CHAIN = "-A output-kura -j RETURN";
    protected static final String RETURN_FORWARD_KURA_CHAIN = "-A forward-kura -j RETURN";
    protected static final String ALLOW_ALL_TRAFFIC_TO_LOOPBACK = "-A input-kura -i lo -j ACCEPT";
    protected static final String ALLOW_ONLY_INCOMING_TO_OUTGOING = "-A input-kura -m state --state RELATED,ESTABLISHED -j ACCEPT";
    protected static final String POSTROUTING_KURA_POLICY = ":postrouting-kura - [0:0]";
    protected static final String PREROUTING_KURA_POLICY = ":prerouting-kura - [0:0]";
    protected static final String FORWARD_KURA_POLICY = ":forward-kura - [0:0]";
    protected static final String OUTPUT_KURA_POLICY = ":output-kura - [0:0]";
    protected static final String INPUT_KURA_POLICY = ":input-kura - [0:0]";
    protected static final String POSTROUTING_ACCEPT_POLICY = ":POSTROUTING ACCEPT [0:0]";
    protected static final String PREROUTING_ACCEPT_POLICY = ":PREROUTING ACCEPT [0:0]";
    protected static final String INPUT_ACCEPT_POLICY = ":INPUT ACCEPT [0:0]";
    protected static final String OUTPUT_ACCEPT_POLICY = ":OUTPUT ACCEPT [0:0]";
    protected static final String FORWARD_ACCEPT_POLICY = ":FORWARD ACCEPT [0:0]";
    protected static final String FORWARD_DROP_POLICY = ":FORWARD DROP [0:0]";
    protected static final String INPUT_DROP_POLICY = ":INPUT DROP [0:0]";
    protected static final String[] IPTABLES_CREATE_INPUT_KURA_CHAIN = { IPTABLES_COMMAND, "-N", INPUT_KURA_CHAIN, "-t",
            FILTER };
    protected static final String[] IPTABLES_CREATE_FORWARD_KURA_CHAIN = { IPTABLES_COMMAND, "-N", FORWARD_KURA_CHAIN,
            "-t", FILTER };
    protected static final String[] IPTABLES_CREATE_OUTPUT_KURA_CHAIN = { IPTABLES_COMMAND, "-N", OUTPUT_KURA_CHAIN,
            "-t", FILTER };
    protected static final String[] IPTABLES_INPUT_DROP_POLICY = { IPTABLES_COMMAND, "-P", INPUT, "DROP" };
    protected static final String[] IPTABLES_FORWARD_DROP_POLICY = { IPTABLES_COMMAND, "-P", FORWARD, "DROP" };
    protected static final String[] IPTABLES_CHECK_INPUT_KURA_CHAIN = { IPTABLES_COMMAND, "-C", INPUT, "-j",
            INPUT_KURA_CHAIN, "-t", FILTER };
    protected static final String[] IPTABLES_CHECK_OUTPUT_KURA_CHAIN = { IPTABLES_COMMAND, "-C", OUTPUT, "-j",
            OUTPUT_KURA_CHAIN, "-t", FILTER };
    protected static final String[] IPTABLES_CHECK_FORWARD_KURA_CHAIN = { IPTABLES_COMMAND, "-C", FORWARD, "-j",
            FORWARD_KURA_CHAIN, "-t", FILTER };
    protected static final String[] IPTABLES_CREATE_INPUT_KURA_CHAIN_NAT = { IPTABLES_COMMAND, "-N", INPUT_KURA_CHAIN,
            "-t", NAT };
    protected static final String[] IPTABLES_CREATE_OUTPUT_KURA_CHAIN_NAT = { IPTABLES_COMMAND, "-N", OUTPUT_KURA_CHAIN,
            "-t", NAT };
    protected static final String[] IPTABLES_CREATE_PREROUTING_KURA_CHAIN = { IPTABLES_COMMAND, "-N",
            PREROUTING_KURA_CHAIN, "-t", NAT };
    protected static final String[] IPTABLES_CREATE_POSTROUTING_KURA_CHAIN = { IPTABLES_COMMAND, "-N",
            POSTROUTING_KURA_CHAIN, "-t", NAT };
    protected static final String[] IPTABLES_CHECK_INPUT_KURA_CHAIN_NAT = { IPTABLES_COMMAND, "-C", INPUT, "-j",
            INPUT_KURA_CHAIN, "-t", NAT };
    protected static final String[] IPTABLES_CHECK_OUTPUT_KURA_CHAIN_NAT = { IPTABLES_COMMAND, "-C", OUTPUT, "-j",
            OUTPUT_KURA_CHAIN, "-t", NAT };
    protected static final String[] IPTABLES_CHECK_PREROUTING_KURA_CHAIN = { IPTABLES_COMMAND, "-C", PREROUTING, "-j",
            PREROUTING_KURA_CHAIN, "-t", NAT };
    protected static final String[] IPTABLES_CHECK_POSTROUTING_KURA_CHAIN = { IPTABLES_COMMAND, "-C", POSTROUTING, "-j",
            POSTROUTING_KURA_CHAIN, "-t", NAT };

    protected static final String COMMAND_EXECUTOR_SERVICE_MESSAGE = "CommandExecutorService not set.";
    protected static final String CHAIN_CREATION_FAILED_MESSAGE = "Failed to create chain";
    protected static final String CHAIN_RETURN_RULE_FAILED_MESSAGE = "Failed to add return rule";

    protected static final String[] ALLOW_ICMP = {
            "-A input-kura -p icmp -m icmp --icmp-type 8 -m state --state NEW,RELATED,ESTABLISHED -j ACCEPT",
            "-A output-kura -p icmp -m icmp --icmp-type 0 -m state --state RELATED,ESTABLISHED -j ACCEPT" };

    protected static final String[] DO_NOT_ALLOW_ICMP = {
            "-A input-kura -p icmp -m icmp --icmp-type 8 -m state --state NEW,RELATED,ESTABLISHED -j DROP",
            "-A output-kura -p icmp -m icmp --icmp-type 0 -m state --state RELATED,ESTABLISHED -j DROP" };

    protected static final String[] FLOODING_PROTECTION_PREROUTING = {
            "-A prerouting-kura -m conntrack --ctstate INVALID -j DROP",
            "-A prerouting-kura -p tcp ! --syn -m conntrack --ctstate NEW -j DROP",
            "-A prerouting-kura -p tcp -m conntrack --ctstate NEW -m tcpmss ! --mss 536:65535 -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags FIN,SYN FIN,SYN -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags SYN,RST SYN,RST -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags FIN,RST FIN,RST -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags FIN,ACK FIN -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags ACK,URG URG -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags ACK,FIN FIN -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags ACK,PSH PSH -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags ALL ALL -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags ALL NONE -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags ALL FIN,PSH,URG -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags ALL SYN,FIN,PSH,URG -j DROP",
            "-A prerouting-kura -p tcp --tcp-flags ALL SYN,RST,ACK,FIN,URG -j DROP",
            "-A prerouting-kura -p icmp -j DROP", "-A prerouting-kura -f -j DROP" };

    protected static final String[] FLOODING_PROTECTION = {
            "-A input-kura -p tcp -m connlimit --connlimit-above 111 -j REJECT --reject-with tcp-reset",
            "-A input-kura -p tcp --tcp-flags RST RST -m limit --limit 2/s --limit-burst 2 -j ACCEPT",
            "-A input-kura -p tcp --tcp-flags RST RST -j DROP",
            "-A input-kura -p tcp -m conntrack --ctstate NEW -m limit --limit 60/s --limit-burst 20 -j ACCEPT",
            "-A input-kura -p tcp -m conntrack --ctstate NEW -j DROP" };

    protected IptablesConfigConstants() {
        // Empty constructor
    }
}
